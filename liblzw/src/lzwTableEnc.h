#ifndef __LZW_TABLE_ENC_H__
#define __LZW_TABLE_ENC_H__

#include "lzwTable.h"

class lzwTableEnc : public lzwTable
{
public:
  lzwTableEnc(int size = DEF_SIZE);
  virtual ~lzwTableEnc();

  virtual bool
  addChain(int prev, unsigned char chr);

  virtual int
  getIndex(int prev, unsigned char chr);

  virtual unsigned char *
  getString(int index, unsigned char * buffer, int buflen, int * len);

private:

  typedef struct __hash
  {
    int next;
    int lzwi;
  } hash;

  hash * m_hash;
};

#endif /* __LZW_TABLE_ENC_H__ */
