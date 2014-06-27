#include"../include/bitio/bitwriter.h"
#include"../include/bitio/bitops.h"

using namespace std;

const unsigned int bitwriter::MIN_BUF_SIZE = 0x00001;
const unsigned int bitwriter::MAX_BUF_SIZE = 0x10000;
const unsigned int bitwriter::DEF_BUF_SIZE = 0x00100;

const unsigned int bitwriter::DEF_WRITE_OFFSET = 0;

bitwriter::bitwriter(unsigned int bufsize /* = DEF_BUF_SIZE */)
{
  m_count = 0;
  m_buf = NULL;
  m_out = NULL;
  
  this->set_bufsize(bufsize);
  
  return;
}

bitwriter::bitwriter(ostream & out,
                     unsigned int bufsize /* = DEF_BUF_SIZE */)
{
  m_count = 0;
  m_buf = NULL;
  m_out = &out;
  
  this->set_bufsize(bufsize);

  return;
}

bitwriter::~bitwriter()
{
  this->flush();
  this->detach();

  if(m_buf != NULL)
  {
    delete [] m_buf;
  }
  
  return;
}

void bitwriter::attach(ostream & out)
{
  this->flush();

  m_out = &out;

  return;
}

void bitwriter::detach()
{
  this->flush();

  m_out = NULL;
  
  return;
}

bool bitwriter::write(const void * buff,
                      unsigned int count,
                      unsigned int offset /* = DEF_WRITE_OFFSET */)
{
  unsigned int i;

  if(count == 0)
  {
    return true;
  }

  if(buff == NULL)
  {
    return false;
  }

  if(m_out == NULL)
  {
    return false;
  }

  if(m_out->good() != true)
  {
    return false;
  }

  for(i=0; i<count; i++)
  {
    if(bitops::is_bit_set(buff, offset + i) == false)
    {
      bitops::unset_bit(m_buf, m_count);
    }
    else
    {
      bitops::set_bit(m_buf, m_count);
    }
    
    m_count ++;
    
    if(m_count == m_bufsize * 8)
    {
      m_out->write(m_buf, m_bufsize);

      if(m_out->good() != true)
      {
        return false;
      }
      
      m_count = 0;
    }
  }

  return true;
}

bool bitwriter::write(int value,
                      unsigned int count)
{
  unsigned char chr [2];

  if(count > 16)
  {
    return false;
  }

  value <<= (16 - count);

  chr[0] = (unsigned char) (0xFF & (value >> 010));
  chr[1] = (unsigned char) (0xFF & (value >> 000));

  return this->write((void *) chr, count);
}

bool bitwriter::flush()
{
  unsigned int i;

  if(m_out == NULL)
  {
    return false;
  }
  
  if(m_count == 0)
  {
    return true;
  }
  
  if(m_count % 8 != 0)
  {
    for(i=m_count % 8; i<8; i++)
    {
      bitops::unset_bit(m_buf, m_count);
      m_count ++;
    }
  }
  
  if(m_out->good() != true)
  {
    return false;
  }

  m_out->write(m_buf, (m_count + 7) / 8);

  if(m_out->good() != true)
  {
    return false;
  }

  m_count = 0;

  return true;
}

void bitwriter::set_bufsize(unsigned int bufsize) throw (bad_alloc)
{
  this->flush();

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

  if(m_buf != NULL)
  {
    delete [] m_buf;
  }

  m_buf = new char [m_bufsize];
  
  if(m_buf == NULL)
  {
    throw bad_alloc();
  }

  m_count = 0;
  
  return;
}
