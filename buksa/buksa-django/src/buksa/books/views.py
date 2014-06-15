from buksa.books.models import Book
from buksa.books.models import Tag

from buksa.books.utils import approximate_size

from django.template import Context, loader
from django.http import HttpResponse, HttpResponseRedirect
from django.http import Http404
from django.db import connection
from django.db.models import Q
from django.utils.encoding import smart_str
from django.conf import settings

from os import SEEK_SET, SEEK_END

def main(request):

    query_all = None
    query_search = None
    query_bytag = None
    query_page = None

    books_count = 0

    page_size = 5

    next_url = None
    prev_url = None

    base_url = None

    try:
        query_all=request.POST['query_all'];
    except(KeyError):
        try:
            query_all=request.GET['query_all'];
        except(KeyError):
            pass
    try:
        query_search=request.POST['query_search'];
    except(KeyError):
        try:
            query_search=request.GET['query_search'];
        except(KeyError):
            pass
    try:
        query_bytag=request.POST['query_bytag'];
    except(KeyError):
        try:
            query_bytag=request.GET['query_bytag'];
        except(KeyError):
            pass
    try:
        query_page=request.POST['query_page'];
    except(KeyError):
        try:
            query_page=request.GET['query_page'];
        except(KeyError):
            pass

    try:
        query_page = int(query_page)
    except:
        query_page = 0

    range_from = query_page * page_size
    range_to = range_from + page_size

    books_list = None

    if query_all != None:
        books_list = Book.objects.all()[range_from:range_to]
        books_count = Book.objects.all().count()
        base_url = 'query_all='
    else:
        if query_search != None:
            query_search = query_search.strip();
            if len(query_search) > 0:
                books_list = Book.objects.filter(Q(title__icontains=query_search) | Q(authors__icontains=query_search))[range_from:range_to]
                books_count = Book.objects.filter(Q(title__icontains=query_search) | Q(authors__icontains=query_search)).count()
                base_url = 'query_search=%s' % query_search
        else:
            if query_bytag != None:
                books_list = Book.objects.filter(tags__id=query_bytag)[range_from:range_to]
                books_count = Book.objects.filter(tags__id=query_bytag).count()
                base_url = 'query_bytag=%s' % query_bytag

    tags_list = Tag.objects.all().order_by('title');

    if base_url != None:
        if query_page != 0:
            prev_url = base_url + '&query_page=%d' % (query_page - 1)
        if range_to < books_count:
            next_url = base_url + '&query_page=%d' % (query_page + 1)

    # Add bindata_size_hr (human readable) to each book
    if books_list != None:
      for book in books_list:
        if book.bindata_size != None:
          book.bindata_size_hr = approximate_size(book.bindata_size)
        else:
          book.bindata_size_hr = None


    # Reference to preview
    if (books_list != None) and (len(books_list) > 0):
      book_id_list = []
      book_id_in = '('
      for book in books_list:
        if len(book_id_list) > 0:
          book_id_in += ','
        book_id_in += '%s'
        book_id_list.append(book.id)
      book_id_in += ')'

      books_p_list = Book.objects.raw('SELECT id FROM v_book_preview WHERE has_preview = TRUE AND id IN ' + book_id_in, book_id_list)

      for book in books_list:
        book.has_preview = False
        for book_p in books_p_list:
          if book.id == book_p.id:
            book.has_preview = True
            break

    template = loader.get_template('main.html')
    context = Context({
        'query_search' : query_search,
        'tags_list' : tags_list,
        'books_list' : books_list,
        'books_count' : books_count,
        'next_url' : next_url,
        'prev_url' : prev_url,
        'current_page' : query_page + 1,
        'total_pages' : int( ( books_count + page_size - 1 ) / page_size )
    })

    return HttpResponse(template.render(context))

def cover(request, book_id):

    cursor = connection.cursor() #@UndefinedVariable
    cursor.execute('SELECT cover_image, cover_image_size FROM book WHERE id=%s', [book_id])
    row = cursor.fetchone()

    if row == None:
        raise Http404

    (cover_image, cover_image_size) = row

    if cover_image == None:
        return HttpResponseRedirect('/images/nocover.gif')

    response = HttpResponse(row[0], 'image/jpeg')

    response['Content-Length'] = cover_image_size

    return response

def bindata(request, book_id):

    cursor = connection.cursor() #@UndefinedVariable
    cursor.execute('SELECT b.bindata, f.mime_type, b.filename, b.bindata_size FROM book b LEFT JOIN format f ON (b.format_id = f.id) WHERE b.id=%s', [book_id])
    row = cursor.fetchone()

    if row == None:
        raise Http404

    (book_oid, mime_type, filename, size) = row

    if mime_type == None:
        mime_type = 'application/octet-stream'

    if filename == None:
        filename = '%d.dat' % book_id

    pg_conn = connection.cursor().cursor.connection #@UndefinedVariable
    pg_lobj = pg_conn.lobject(oid=book_oid, mode='r')

    response = HttpResponse(mimetype = str(mime_type))

    response['Content-Length'] = size
    response['Content-Disposition'] = 'attachment; filename="%s"' % smart_str(filename, settings.DEFAULT_CHARSET)

    response.write(pg_lobj.read(-1))

    return response
