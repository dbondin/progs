#ifndef __BITIO_VERSION_H__
#define __BITIO_VERSION_H__

#ifndef MAJOR_VERSION
#define MAJOR_VERSION 0
#endif

#ifndef MINOR_VERSION
#define MINOR_VERSION 0
#endif

#ifndef VERSION_STRING
#define VERSION_STRING "0.0"
#endif

class bitio_version
{
public:

  static int get_major_version();
  static int get_minor_version();
  static const char * get_version_string();

};

#endif /* __BITIO_VERSION_H__ */
