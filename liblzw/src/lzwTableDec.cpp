#include "lzwTableDec.h"

#ifndef NULL
#define NULL 0
#endif /* NULL */

lzwTableDec::lzwTableDec(int size /* = DEF_SIZE */) : lzwTable(size)
{
  return;
}

bool
lzwTableDec::addChain(int prev, unsigned char chr)
{
  return lzwTable::addChain(prev, chr);
}

int
lzwTableDec::getIndex(int prev, unsigned char chr)
{
  return -1;
}

unsigned char *
lzwTableDec::getString(int index, unsigned char * buffer, int buflen, int * len)
{
  int lzwl;

  if(index < 0 ||
     index >= m_count)
  {
    return NULL;
  }

  lzwl = m_data[index].len;

  if(lzwl > buflen)
  {
    return NULL;
  }

  *len = lzwl;

  while(lzwl != 0)
  {
    buffer[lzwl - 1] = m_data[index].chr;
    index = m_data[index].prev;
    lzwl --;
  }

  return buffer;
}

