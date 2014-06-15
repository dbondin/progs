#include <unistd.h>
#include "myprintf.h"

int printf (__const char *__restrict __format, ...) {
  write(1, "BE-BE-BE\n", 9);
  return 0;
}
