#include "fnames.h"

#include <stdio.h>
#include <string.h>

int fnames_rtov(const char *from, char *to, size_t to_len, int to_index)
{
    int res = snprintf(to, to_len, "%05d_%s", to_index, from);
    return (res >=0 && res < to_len) ? 0 : 1;
}

int fnames_vtor(const char *from, char *to, size_t to_len)
{
    strncpy(to, &from[6], to_len);
    return 0;
}
