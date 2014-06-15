#include <stdlib.h>
#include <unistd.h>

#include "common.h"

void run(int argc, char ** argv, const char * filename)
{
  int i;
  char ** plargv;
  int plargc;

  if(argc == 1)
  {
    plargc = argc + 2;
  }
  else
  {
    plargc = argc + 1;
  }

  plargv = (char **) malloc(sizeof(char *) * plargc);
  plargv[plargc - 1] = (char *) NULL;

  if(argc == 1)
  {
    plargv[0] = MLAUNCH_DEF_PROG;
  }
  else
  {
    for(i=1; i<argc; i++)
    {
      plargv[i-1] = argv[i];
    }
  }

  plargv[plargc - 2] = (char *) filename;

  execvp(plargv[0], plargv);

  return;
}
