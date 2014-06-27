#include <fstream>
#include <bitio/bitio.h>

#include "../include/liblzw/liblzw.h"
#include "lzwTableEnc.h"
#include "lzwdebug.h"

bool
lzwEncode(std::istream & in,
          std::ostream & out,
          int max)
{
  lzwTableEnc * lzwt;
  bitwriter   * bitw;
  int           lzwtsize;

  int           index;
  int           nextIndex;
  unsigned char chr;

  int           lzwSize;
  int           lzwLimit;
  int           lzwBits;

  LZW_TRACE("lzwEncode() called");

  if(max < 8 ||
     max > 16)
  {
    LZW_TRACE("lzwEncode() error: invalid <max> value");
    return false;
  }

  if(in.good() != true)
  {
    LZW_TRACE("lzwEncode() error: invalid input stream");
    return false;
  }

  if(out.good() != true)
  {
    LZW_TRACE("lzwEncode() error: invalid output stream");
    return false;
  }

  lzwtsize = (0x0001 << max);

  LZW_TRACE("lzwEncode() LZW table size: %d", lzwtsize);

  lzwt = new lzwTableEnc(lzwtsize);
  bitw = new bitwriter(out);

  index     = -1;
  nextIndex = -1;
  lzwSize = 256;
  lzwBits = 8;
  lzwLimit = 256;
  LZW_TRACE("lzwEncode() Encoding started");
  while(true)
  {
    in.read((char *)&chr, 1);

    if(in.good() != true)
    {
      break;
    }

    LZW_TRACE("lzwEncode() chr       = %d (0x%.2x)", chr, chr);

    nextIndex = lzwt->getIndex(index, chr);

    LZW_TRACE("lzwEncode() index     = %d", index);
    LZW_TRACE("lzwEncode() nextIndex = %d", nextIndex);

    if(nextIndex != -1)
    {
      LZW_TRACE("lzwEncode() index+chr in table: yes");
      index = nextIndex;
    }
    else
    {
      LZW_TRACE("lzwEncode() index+chr in table: no");
      if(lzwt->addChain(index, chr) == true)
      {
        if(lzwSize > lzwLimit)
        {
          lzwBits ++;
          lzwLimit <<= 1;
        }
        lzwSize ++;
      }

      LZW_TRACE("lzwEncode() write %d as %d bits", index, lzwBits);
      bitw->write(index, lzwBits);
      index = (int) chr;
    }

    LZW_TRACE("");
  }

  if(index != -1)
  {
    LZW_TRACE("lzwEncode() last write %d as %d bits", index, lzwBits);
    bitw->write(index, lzwBits);
  }

  delete bitw;
  delete lzwt;

  return true;
}
