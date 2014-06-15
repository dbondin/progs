from django.contrib import admin
from django.conf.urls.defaults import patterns

admin.autodiscover()

urlpatterns = patterns('',
    (r'^$', 'buksa.books.views.main'),
    (r'^books/$', 'buksa.books.views.main'),
    (r'^books/cover/(?P<book_id>\d+)$', 'buksa.books.views.cover'),
    (r'^books/bindata/(?P<book_id>\d+)$', 'buksa.books.views.bindata'),
    (r'^preview/(?P<book_id>\d+)$', 'buksa.preview.views.main'),
    (r'^preview/(?P<book_id>\d+)/(?P<pageno>\d+)$', 'buksa.preview.views.page'),
)

#
# FOR LOCAL DEBUG ONLY !!!
#
urlpatterns += patterns('django.views.static',
    (r'^css/(?P<path>.*)$',
        'serve',
            {'document_root': '/home/dbondin/progs/buksa/buksa-django/media/css',
             'show_indexes': True
            }
    )
)
urlpatterns += patterns('django.views.static',
    (r'^images/(?P<path>.*)$',
        'serve',
            {'document_root': '/home/dbondin/progs/buksa/buksa-django/media/images',
             'show_indexes': True
            }
    )
)
urlpatterns += patterns('django.views.static',
    (r'^js/(?P<path>.*)$',
        'serve',
            {'document_root': '/home/dbondin/progs/buksa/buksa-django/media/js',
             'show_indexes': True
            }
    )
)
