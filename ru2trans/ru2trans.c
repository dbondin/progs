#include<stdio.h>
#include"ru2trans_tbl.h"

int main(int argc, char ** argv)
{
  int chr;
  size_t bread;
  
  while((chr = fgetc(stdin)) != EOF)
  {
    fputs(ru2trans_tbl[chr], stdout);
  }

  return;
}
