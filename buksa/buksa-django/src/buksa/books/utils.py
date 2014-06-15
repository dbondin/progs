SUFFIXES = ['Kbytes', 'Mbytes', 'Gbytes', 'Tbytes']

def approximate_size(size):

  if size < 1024:
    return str(size) + ' bytes'

  for suffix in SUFFIXES:
    size /= 1024
    if size < 1024:
      return '{0:.1f} {1}'.format(size, suffix)

  raise ValueError('size too large !!!')
