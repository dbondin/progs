#include "lzwTable.h"

lzwTable::lzwTable(int size /* = DEF_SIZE */)
{
  if(size < lzwTable::MIN_SIZE)
  {
    m_size = lzwTable::MIN_SIZE;
  }
  else if(size > lzwTable::MAX_SIZE)
  {
    m_size = lzwTable::MAX_SIZE;
  }
  else
  {
    m_size = size;
  }

  m_data = new lzwe[m_size];

  for(m_count=0; m_count<lzwTable::MIN_SIZE; m_count++)
  {
    m_data[m_count].chr  = (unsigned char) m_count;
    m_data[m_count].prev = -1;
    m_data[m_count].len  = 1;
  }

  return;
}

lzwTable::~lzwTable()
{
  delete [] m_data;
}

int
lzwTable::getCount()
{
  return m_count;
}

int
lzwTable::getSize()
{
  return m_size;
}

bool
lzwTable::isEmpty()
{
  return (m_count == 0) ? true : false;
}

bool
lzwTable::isFull()
{
  return (m_count == m_size) ? true : false;
}

bool
lzwTable::addChain(int prev, unsigned char chr)
{
  if(this->isFull())
  {
    return false;
  }

  if(prev < 0 ||
     prev >= m_count)
  {
    return false;
  }

  m_data[m_count].chr = chr;
  m_data[m_count].prev = prev;
  m_data[m_count].len = m_data[prev].len + 1;

  m_count ++;

  return true;
}
