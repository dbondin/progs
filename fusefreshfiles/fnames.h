#ifndef FNAMES
#define FNAMES

#include <stddef.h>

/**
 * Real to Virtual
 * 
 * @return 0 on success
 */
int fnames_rtov(const char * from, char * to, size_t to_len, int to_index);

/**
 * Virtual to Real
 * 
 * @return 0 on success
 */
int fnames_vtor(const char * from, char * to, size_t to_len);

#endif /* FNAMES */
