INSTALL_PREFIX = '/home/dbondin/workspace/django-test/src'

DEBUG = True
TEMPLATE_DEBUG = DEBUG

ADMINS = (
)

MANAGERS = ADMINS

DATABASE_ENGINE = 'postgresql_psycopg2'
DATABASE_NAME = 'dbondin'
DATABASE_USER = 'dbondin'
DATABASE_PASSWORD = ''
DATABASE_HOST = ''
DATABASE_PORT = ''

TIME_ZONE = 'Europe/Moscow'

LANGUAGE_CODE = 'ru-ru'

SITE_ID = 1

USE_I18N = True

MEDIA_ROOT = ''

MEDIA_URL = ''

ADMIN_MEDIA_PREFIX = '/media/'

SECRET_KEY = 'f4b3@0%0_7z&!ai1xml)_ffc*5f^(8gav_$ekr7gi@ysd%zkgx'

TEMPLATE_LOADERS = (
    'django.template.loaders.filesystem.load_template_source',
    'django.template.loaders.app_directories.load_template_source',
)

MIDDLEWARE_CLASSES = (
    'django.middleware.common.CommonMiddleware',
    'django.contrib.sessions.middleware.SessionMiddleware',
    'django.contrib.auth.middleware.AuthenticationMiddleware',
)

ROOT_URLCONF = 'buksa.urls'

TEMPLATE_DIRS = (
    INSTALL_PREFIX + '/buksa/books/templates',
    INSTALL_PREFIX + '/buksa/preview/templates'
)

INSTALLED_APPS = (
    #'django.contrib.auth',
    #'django.contrib.contenttypes',
    #'django.contrib.sessions',
    #'django.contrib.sites',
    #'django.contrib.admin',
    'buksa.books',
    'buksa.preview'
)
