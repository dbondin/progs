#include "../include/bitio/bitio_version.h"

int bitio_version::get_major_version()
{
  return MAJOR_VERSION;
}

int bitio_version::get_minor_version()
{
  return MINOR_VERSION;
}

const char * bitio_version::get_version_string()
{
  return VERSION_STRING;
}
