from buksa.preview.models import VBookPreview

from buksa.books.utils import approximate_size

from django.template import Context, loader
from django.http import HttpResponse, HttpResponseRedirect
from django.http import Http404
from django.db import connection
from django.db.models import Q
from django.utils.encoding import smart_str
from django.conf import settings

def main(request, book_id):

    if book_id == None:
        raise Http404

    vbp_list = VBookPreview.objects.filter(id=book_id)

    if len(vbp_list) == 0:
        raise Http404

    vbp = vbp_list[0]

    if vbp == None:
        raise Http404

    if vbp.has_preview != True:
        raise Http404

    template = loader.get_template('preview.html')
    context = Context({
        'vbp' : vbp
    })

    return HttpResponse(template.render(context))

def page(request, book_id, pageno):

    cursor = connection.cursor()
    cursor.execute('SELECT page_image, octet_length(page_image) FROM preview_page WHERE preview_id=%s AND pageno=%s', [book_id, pageno])
    row = cursor.fetchone()

    if row == None:
        raise Http404

    (page_image, page_image_size) = row

    if page_image == None:
        raise Http404

    response = HttpResponse(page_image, 'image/jpeg')

    response['Content-Length'] = page_image_size

    return response
