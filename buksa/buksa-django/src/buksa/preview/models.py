from django.db import models

class VBookPreview(models.Model):
    id = models.AutoField(primary_key=True)
    title = models.CharField(max_length=256)
    authors = models.CharField(max_length=128, blank=True)
    pages_num = models.IntegerField(null=True, blank=True)
    has_preview = models.BooleanField(null=False, blank=True)

    def __unicode__(self):
        return self.title

    class Meta:
        db_table = u'v_book_preview'
