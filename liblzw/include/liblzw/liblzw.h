#ifndef __LIB_LZW_H__
#define __LIB_LZW_H__

#include <iostream>

extern bool
lzwEncode(std::istream & in,
          std::ostream & out,
          int max);

extern bool
lzwDecode(std::istream & in,
          std::ostream & out,
          int max);

#endif /* __LIB_LZW_H__ */
