#ifndef __BITREADER_H__
#define __BITREADER_H__

#include<new>
#include<istream>

class bitreader
{

public:

  static const unsigned int MIN_BUF_SIZE;
  static const unsigned int MAX_BUF_SIZE;
  static const unsigned int DEF_BUF_SIZE;
  
  static const unsigned int DEF_READ_OFFSET;

  bitreader(unsigned int bufsize = DEF_BUF_SIZE);

  bitreader(std::istream & in,
            unsigned int bufsize = DEF_BUF_SIZE);
            
  ~bitreader();
  
  void attach(std::istream & in);
  
  void detach();

  int read(unsigned int count);

  unsigned int read(void * buff,
		    unsigned int count,
		    unsigned int offset = DEF_READ_OFFSET);

  void set_bufsize(unsigned int bufsize) throw (std::bad_alloc);

  inline void clear()
  {
    m_count = 0;
    m_pos = 0;

    return;
  }
  
  inline unsigned int get_bufsize() const
  {
    return m_bufsize;
  }


private:

  std::istream * m_in;

  char * m_buf;

  unsigned int m_bufsize;

  unsigned int m_count;

  unsigned int m_pos;

};

#endif /* __BITREADER_H__ */
