from django.db import models

class Format(models.Model):
    id = models.AutoField(primary_key=True)
    title = models.CharField('Title', max_length=64)
    description = models.CharField('Description', max_length=256)
    extension = models.CharField('Extension', max_length=16)
    mime_type = models.CharField('MIME Type', max_length=64)
    ctime = models.DateTimeField('Creation Time', editable=False)
    mtime = models.DateTimeField('Modification Time', editable=False)
    
    def __unicode__(self):
        return self.title
    
    class Meta:
        db_table = u'format'
        
class Tag(models.Model):
    id = models.AutoField(primary_key=True)
    title = models.CharField('Title', unique=True, max_length=256)
    ctime = models.DateTimeField('Creation Time', editable=False)
    mtime = models.DateTimeField('Modification Time', editable=False)
    
    def __unicode__(self):
        return self.title

    class Meta:
        db_table = u'tag'
        
class Book(models.Model):
    id = models.AutoField(primary_key=True)
    title = models.CharField(max_length=256)
    authors = models.CharField(max_length=128, blank=True)
    publisher = models.CharField(max_length=128, blank=True)
    year = models.IntegerField(null=True, blank=True)
    filename = models.CharField(max_length=256)
    description = models.CharField(max_length=256, blank=True)
    ctime = models.DateTimeField('Creation Time', editable=False)
    mtime = models.DateTimeField('Modification Time', editable=False)
    format = models.ForeignKey(Format, null=True, blank=True)
    tags = models.ManyToManyField(Tag, db_table=u'book_tag', blank=True)
    cover_image_size = models.IntegerField(null=True, blank=True)
    bindata_size = models.IntegerField(null=True, blank=True)

    def __unicode__(self):
        return self.title
        
    class Meta:
        db_table = u'book'
        
