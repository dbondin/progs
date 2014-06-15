#include <stdio.h>
#include <dlfcn.h>

int main(int argc, char ** argv) {

  void * dlp = NULL;
  double (*calc)(const char *, int *);
  double result;
  int status;

  if(argc < 2) {
    fprintf(stderr, "Usage: test_dynamic filename\n");
    return 1;
  }

  dlp = dlopen(argv[1], RTLD_LAZY);

  if(dlp == NULL) {
    fprintf(stderr, "Error opening library '%s'", argv[1]);
    return 2;
  }
  
  calc = dlsym(dlp, "calculator");

  if(calc != NULL) {
    result = calc("2+2", &status);
    if(status == 0) {
      printf("OK: %s=%f\n", "2+2", result);
    }
    else {
      printf("ERROR\n");
    }

  }
  else {
    fprintf(stderr, "Error finding symbol calculator in library '%s'", argv[1]);
    dlclose(dlp);
    return 3;
  }
  dlclose(dlp);
}
