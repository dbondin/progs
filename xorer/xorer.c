#include <stdio.h>
#include <string.h>

int main(int argc, char ** argv) {

  char * key;
  int l;
  int i = 0;
  int c;

  if(argc < 2) {
    fprintf(stderr, "Missing key\n");
    return 1;
  }

  key = argv[1];
  l = strlen(key);

  while(1) {
    c = fgetc(stdin);
    if(c==EOF) {
      break;
    }
    fputc(c^((int)key[i]), stdout);
    i=(i+1)%l;
  }
  
  return 0;
}
