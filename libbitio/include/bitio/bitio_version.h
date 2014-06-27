#ifndef __BITIO_VERSION_H__
#define __BITIO_VERSION_H__

class bitio_version
{
public:

  static int get_major_version();
  static int get_minor_version();
  static const char * get_version_string();

};

#endif /* __BITIO_VERSION_H__ */
