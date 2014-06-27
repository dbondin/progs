#include <iostream>
#include <fstream>
#include <sys/stat.h>
#include <stdlib.h>
#include <string.h>

#include "../include/liblzw/liblzw.h"

typedef enum { ENCODE, DECODE } WORKING_MODE;

static const char LZW_HEADER [] = {'L', 'Z', 'W', '0', '9'};

static bool writeHeader(std::ostream & out, unsigned char max, unsigned long int fileSize);
static bool readHeader(std::istream & in, unsigned char * max, unsigned long int * fileSize);
static bool writeFileSize(unsigned long int value, std::ostream & out);
static bool readFileSize(std::istream & in, unsigned long int * value);
static void printUsage();
static bool getFileSize(const char * filename, unsigned long int * size);


int main(int argc, char ** argv)
{
  WORKING_MODE wm;
  std::ifstream in;
  std::ofstream out;
  unsigned char max = 0;
  unsigned long int fileSize;
  unsigned long int fileSizeInHeader;

  if(argc != 4 &&
     argc != 5)
  {
    printUsage();
    return 1;
  }

  if(argv[1][1] != 0)
  {
    printUsage();
    return 2;
  }

  if(argv[1][0] == 'e' && argc == 5)
  {
    wm = ENCODE;
    max = atoi(argv[4]);

    if(max < 8 ||
       max > 16)
    {
      printUsage();
      return 6;
    }
  }
  else if(argv[1][0] == 'd' && argc == 4)
  {
    wm = DECODE;
  }
  else
  {
    printUsage();
    return 3;
  }

  in.open(argv[2], std::ios_base::in | std::ios_base::binary);

  if(in.good() != true)
  {
    std::cerr << "Error opening input file" << std::endl;
    return 4;
  }

  out.open(argv[3], std::ios_base::out | std::ios_base::binary);

  if(out.good() != true)
  {
    std::cerr << "Error opening output file" << std::endl;
    in.close();
    return 5;
  }

  if(wm == ENCODE)
  {
    if(getFileSize(argv[2], &fileSize) != true)
    {
      std::cerr << "Error while getting input file size" << std::endl;
      out.close();
      in.close();
      return 9;
    }

    if(writeHeader(out, max, fileSize) != true)
    {
      std::cerr << "Error while writing header data" << std::endl;
      out.close();
      in.close();
      return 8;
    }

    if(lzwEncode(in, out, max) != true)
    {
      std::cerr << "Error while encoding" << std::endl;
      out.close();
      in.close();
      return 7;
    }

    out.close();
    in.close();
  }
  else
  {
    if(readHeader(in, &max, &fileSizeInHeader) != true)
    {
      std::cerr << "Error while reading LZW header" << std::endl;
      out.close();
      in.close();
      return 10;
    }

    if(max < 8 ||
       max > 16)
    {
      std::cerr << "Invalid data in LZW header: max value is out of range" << std::endl;
      out.close();
      in.close();
      return 11;
    }

    if(lzwDecode(in, out, max) != true)
    {
      std::cerr << "Error while encoding" << std::endl;
      out.close();
      in.close();
      return 12;
    }

    out.close();
    in.close();

    if(getFileSize(argv[3], &fileSize) != true)
    {
      std::cerr << "Error while getting resulting file size" << std::endl;
      out.close();
      in.close();
      return 13;
    }

    if(fileSize != fileSizeInHeader)
    {
      std::cerr << "Error: decoded file size differs from stored one." << std::endl;
      std::cerr << "       LZW header info: " << fileSizeInHeader << std::endl;
      std::cerr << "       Resulting file : " << fileSize << std::endl;
      out.close();
      in.close();
      return 14;
    }
  }

  return 0;
}


bool writeHeader(std::ostream & out, unsigned char max, unsigned long int fileSize)
{
  out.write(LZW_HEADER, sizeof(LZW_HEADER));
  if(out.good() != true)
  {
    return false;
  }

  out.write((char *)&max, 1);
  if(out.good() != true)
  {
    return false;
  }

  return writeFileSize(fileSize, out);
}

bool readHeader(std::istream & in, unsigned char * max, unsigned long int * fileSize)
{
  unsigned char buf[sizeof(LZW_HEADER)];
  unsigned char imax;
  unsigned long int ifileSize;

  in.read((char *)buf, sizeof(LZW_HEADER));
  if(in.gcount() != sizeof(LZW_HEADER))
  {
    return false;
  }
  if(memcmp(LZW_HEADER, buf, sizeof(LZW_HEADER)) != 0)
  {
    return false;
  }
  in.read((char *)&imax, 1);
  if(in.gcount() != 1)
  {
    return false;
  }
  if(readFileSize(in, &ifileSize) != true)
  {
    return false;
  }

  if(max != NULL)
  {
    *max = imax;
  }

  if(fileSize != NULL)
  {
    *fileSize = ifileSize;
  }

  return true;
}

bool writeFileSize(unsigned long int value, std::ostream & out)
{
  char buf[4];

  if(out.good() != true)
  {
    return false;
  }

  buf[0] = ((value >> 030) & 0xff);
  buf[1] = ((value >> 020) & 0xff);
  buf[2] = ((value >> 010) & 0xff);
  buf[3] = ((value >> 000) & 0xff);

  out.write(buf, 4);

  return out.good();
}

bool readFileSize(std::istream & in, unsigned long int * value)
{
  unsigned char buf[4];

  in.read((char *)buf, 4);

  if(in.gcount() != 4)
  {
    return false;
  }

  if(value != NULL)
  {
    *value = buf[0];
    *value <<= 8;
    *value += buf[1];
    *value <<= 8;
    *value += buf[2];
    *value <<= 8;
    *value += buf[3];
  }

  return true;
}

void printUsage()
{
  std::cerr << "Usage: lzwtest e <infile> <outfile> <max> - for encoding" << std::endl;
  std::cerr << "       lzwtest d <infile> <outfile>       - for decoding" << std::endl;
  std::cerr << std::endl;
  std::cerr << "       Where: <infile>  - input file" << std::endl;
  std::cerr << "       Where: <outfile> - output file" << std::endl;
  std::cerr << "       Where: <max>     - maximum lzw table size [8..16]" << std::endl;

  return;
}

static bool getFileSize(const char * filename, unsigned long int * size)
{
  struct stat st;

  if(stat(filename, &st) != 0)
  {
    return false;
  }

  if(size != NULL)
  {
    *size = st.st_size;
  }

  return true;
}
