#ifndef __LZW_TABLE_H__
#define __LZW_TABLE_H__

class lzwTable
{
public:

  enum { MIN_SIZE = 256 };
  enum { MAX_SIZE = 65536 };
  enum { DEF_SIZE = MAX_SIZE };

  lzwTable(int size = DEF_SIZE);
  virtual ~lzwTable();

  int
  getCount();

  int
  getSize();

  bool
  isEmpty();

  bool
  isFull();


  virtual bool
  addChain(int prev, unsigned char chr);

  virtual int
  getIndex(int prev, unsigned char chr) = 0;

  virtual unsigned char *
  getString(int index, unsigned char * buffer, int buflen, int * len) = 0;

protected:

  typedef struct __lzwe
  {
    unsigned char chr;
    int           prev;
    int           len;
  } lzwe;

  lzwe * m_data;
  int    m_size;
  int    m_count;
};

#endif /* __LZW_TABLE_H__ */
