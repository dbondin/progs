#include"../include/bitio/bitreader.h"
#include"../include/bitio/bitops.h"

using namespace std;

const unsigned int bitreader::MIN_BUF_SIZE = 0x00001;
const unsigned int bitreader::MAX_BUF_SIZE = 0x10000;
const unsigned int bitreader::DEF_BUF_SIZE = 0x00100;
  
const unsigned int bitreader::DEF_READ_OFFSET = 0;

bitreader::bitreader(unsigned int bufsize /* = DEF_BUF_SIZE */)
{
  m_in = NULL;
  m_buf = NULL;
  m_count = 0;
  m_pos = 0;
  m_bufsize = 0;

  this->set_bufsize(bufsize);

  return;
}

bitreader::bitreader(std::istream & in,
		     unsigned int bufsize /* = DEF_BUF_SIZE */)
{
  m_in = &in;
  m_buf = NULL;
  m_count = 0;
  m_pos = 0;
  m_bufsize = 0;

  this->set_bufsize(bufsize);

  return;
}
            
bitreader::~bitreader()
{
  if(m_buf != NULL)
  {
    delete [] m_buf;
  }

  return;
}

void bitreader::attach(std::istream & in)
{
  this->clear();
  m_in = &in;

  return;
}
 
void bitreader::detach()
{
  this->clear();
  m_in = NULL;

  return;
}

int bitreader::read(unsigned int count)
{
  unsigned char chr[2] = {0, 0};
  int res;

  if(count > 16)
  {
    return -1;
  }

  unsigned int z = this->read(&chr, count);

  if(z != count)
  {
    return -1;
  }

  res = chr[0];
  res <<= 8;
  res += chr[1];

  res >>= (16 - count);

  return res;
}

unsigned int bitreader::read(void * buff,
			     unsigned int count,
			     unsigned int offset /* = DEF_READ_OFFSET */)
{
  unsigned int i;
  unsigned int read_bytes;

  if(m_in == NULL)
  {
    return false;
  }

  if(m_buf == NULL)
  {
    return false;
  }

  for(i=0; i<count; i++)
  {
    if(m_pos == m_count)
    {
      m_in->read(m_buf, m_bufsize);
      
      read_bytes = m_in->gcount();

      if(read_bytes == 0)
      {
        return i;
      }
      
      m_count = read_bytes * 8;
      
      m_pos = 0;
    }
    
    if(buff != NULL)
    {
      if(bitops::is_bit_set(m_buf, m_pos) == false)
      {
        bitops::unset_bit(buff, offset + i);
      }
      else
      {
        bitops::set_bit(buff, offset + i);
      }
    }

    m_pos ++;    
  }

  return i;
}

void bitreader::set_bufsize(unsigned int bufsize) throw (bad_alloc)
{
  if(bufsize < MIN_BUF_SIZE)
  {
    m_bufsize = MIN_BUF_SIZE;
  }
  else if(bufsize > MAX_BUF_SIZE)
  {
    m_bufsize = MAX_BUF_SIZE;
  }
  else
  {
    m_bufsize = bufsize;
  }

  m_count = 0;
  m_pos = 0;

  if(m_buf != NULL)
  {
    delete [] m_buf;
    
    m_buf = NULL;
  }

  m_buf = new char [m_bufsize];
  
  if(m_buf == NULL)
  {
    throw bad_alloc();
  }

  return;
}
