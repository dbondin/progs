#include "lzwdebug.h"

#include <cstdio>
#include <cstdarg>

void LZW_TRACE(const char * format, ...)
{
#ifdef LZWDEBUG

  va_list args;

  va_start(args, format);

  fprintf(stderr, "LZW_TRACE: ");
  vfprintf(stderr, format, args);
  fprintf(stderr, "\n" );

  va_end(args);

#endif /* LZWDEBUG */

  return;
}
