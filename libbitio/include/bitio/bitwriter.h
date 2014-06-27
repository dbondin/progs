#ifndef __BITWRITER_H__
#define __BITWRITER_H__

#include<new>
#include<ostream>

class bitwriter
{

public:

  static const unsigned int MIN_BUF_SIZE;
  static const unsigned int MAX_BUF_SIZE;
  static const unsigned int DEF_BUF_SIZE;
  
  static const unsigned int DEF_WRITE_OFFSET;

  bitwriter(unsigned int bufsize = DEF_BUF_SIZE);

  bitwriter(std::ostream & out,
            unsigned int bufsize = DEF_BUF_SIZE);
            
  ~bitwriter();
  
  void attach(std::ostream & out);
  
  void detach();
  
  bool write(const void * buff,
             unsigned int count,
             unsigned int offset = DEF_WRITE_OFFSET);

  bool write(int value,
             unsigned int count);

  bool flush();
  
  void set_bufsize(unsigned int bufsize) throw (std::bad_alloc);

  inline void clear()
  {
    m_count = 0;
  
    return;
  }
  
  inline bool is_empty() const
  {
    return m_count == 0;
  }
  
  inline unsigned int get_count() const
  {
    return m_count;
  }

  inline unsigned int get_bufsize() const
  {
    return m_bufsize;
  }

private:

  std::ostream * m_out;

  char * m_buf;
  
  unsigned int m_bufsize;
  
  unsigned int m_count;
};

#endif /* __BITWRITER_H__ */
