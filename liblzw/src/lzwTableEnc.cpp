#include "lzwTableEnc.h"
#include "lzwdebug.h"

#ifndef NULL
#define NULL 0
#endif /* NULL */

lzwTableEnc::lzwTableEnc(int size /* = DEF_SIZE */ ) : lzwTable(size)
{
  int hindex;

  m_hash = new hash[this->getSize()];

  for(hindex = 0; hindex < lzwTable::MIN_SIZE; hindex++)
  {
    m_hash[hindex].next = -1;
    m_hash[hindex].lzwi = hindex;
  }

  return;
}

lzwTableEnc::~lzwTableEnc()
{
  delete [] m_hash;
}

bool
lzwTableEnc::addChain(int prev, unsigned char chr)
{
  int hindex;

  if(lzwTable::addChain(prev, chr) != true)
  {
    LZW_TRACE("lzwTableEnc::addChain() can't add");
    return false;
  }

  hindex = (int) chr;

  while(m_hash[hindex].next != -1)
  {
    hindex = m_hash[hindex].next;
  }

  LZW_TRACE("lzwTableEnc::addChain() adding from hindex = %d to hindex = %d", hindex, m_count - 1);

  m_hash[hindex].next = m_count - 1;
  m_hash[m_count - 1].lzwi = m_count - 1;
  m_hash[m_count - 1].next = -1;

  return true;
}

int
lzwTableEnc::getIndex(int prev, unsigned char chr)
{
  int hindex;

  hindex = (int) chr;

  while(hindex != -1)
  {
    LZW_TRACE("lzwTableEnc::getIndex() hindex = %d", hindex);
    LZW_TRACE("lzwTableEnc::getIndex() m_hash[hindex] = %d", m_hash[hindex]);

    if(m_data[m_hash[hindex].lzwi].prev == prev)
    {
      LZW_TRACE("lzwTableEnc::getIndex() found");
      return m_hash[hindex].lzwi;
    }

    hindex = m_hash[hindex].next;
  }

  LZW_TRACE("lzwTableEnc::getIndex() not found");

  return -1;
}

unsigned char *
lzwTableEnc::getString(int index, unsigned char * buffer, int buflen, int * len)
{
  return NULL;
}
