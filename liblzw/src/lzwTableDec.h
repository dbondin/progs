#ifndef __LZW_TABLE_DEC_H__
#define __LZW_TABLE_DEC_H__

#include "lzwTable.h"

class lzwTableDec : public lzwTable
{
public:
  lzwTableDec(int size = DEF_SIZE);

  virtual bool
  addChain(int prev, unsigned char chr);

  virtual int
  getIndex(int prev, unsigned char chr);

  virtual unsigned char *
  getString(int index, unsigned char * buffer, int buflen, int * len);
};

#endif /* __LZW_TABLE_DEC_H__ */
