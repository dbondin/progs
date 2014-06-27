#include <fstream>
#include <bitio/bitio.h>

#include "../include/liblzw/liblzw.h"
#include "lzwTableDec.h"
#include "lzwdebug.h"

bool
lzwDecode(std::istream & in, std::ostream & out, int max)
{
  lzwTableDec * lzwt;
  bitreader   * bitr;
  int           lzwtsize;

  int           index;
  int           prevIndex;

  int           lzwSize;
  int           lzwLimit;
  int           lzwBits;

  unsigned char chainBuf[0x10000];
  int           chainLen;

  LZW_TRACE("lzwDecode() called");

  if(max < 8 ||
     max > 16)
  {
    LZW_TRACE("lzwDecode() error: invalid <max> value");
    return false;
  }

  if(in.good() != true)
  {
    LZW_TRACE("lzwDecode() error: invalid input stream");
    return false;
  }

  if(out.good() != true)
  {
    LZW_TRACE("lzwDecode() error: invalid output stream");
    return false;
  }

  lzwtsize = (0x0001 << max);

  LZW_TRACE("lzwDecode() LZW table size: %d", lzwtsize);

  lzwt = new lzwTableDec(lzwtsize);
  bitr = new bitreader(in);

  lzwSize = 256 + 1;
  lzwBits = 8;
  lzwLimit = 256;
  LZW_TRACE("lzwDecode() Decoding started");

  index = bitr->read(lzwBits);
  if(index != -1)
  {
    LZW_TRACE("lzwDecode() first index = %d", index);
    if(lzwt->getString(index, chainBuf, 0x10000, &chainLen) != NULL)
    {
      LZW_TRACE("lzwDecode() first symbol = %d (%.2x)", chainBuf[0], chainBuf[0]);

      out.write((char *)chainBuf, chainLen);

      if(out.good() != true)
      {
        LZW_TRACE("lzwDecode() Out failed");
        return false;
      }
    }

    while(true)
    {
      prevIndex = index;

      /* Computer new proposed lzw bits value */
      if(lzwBits < max &&
         lzwSize > lzwLimit)
      {
        lzwBits ++;
        lzwLimit <<= 1;
      }

      index = bitr->read(lzwBits);

      LZW_TRACE("lzwDecode() next index = %d (with %d bits)", index, lzwBits);

      if(index == -1)
      {
        break;
      }

      if(lzwt->getString(index, chainBuf, 0x10000, &chainLen) != NULL)
      {
        out.write((char *)chainBuf, chainLen);

        if(out.good() != true)
        {
          LZW_TRACE("lzwDecode() Out failed");
          return false;
        }

        if(lzwt->addChain(prevIndex, chainBuf[0]) == true)
        {
          lzwSize ++;
        }
      }
      else
      {
        lzwt->getString(prevIndex, chainBuf, 0x10000, &chainLen);
        if(lzwt->addChain(prevIndex, chainBuf[0]) == true)
        {
          lzwSize ++;
        }

        chainBuf[chainLen] = chainBuf[0];

        out.write((char *)chainBuf, chainLen + 1);

        if(out.good() != true)
        {
          LZW_TRACE("lzwDecode() Out failed");
          return false;
        }
      }
    }
  }

  return true;
}
