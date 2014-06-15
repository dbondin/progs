#include <stdio.h>
#include <calculator.h>

int main(int argc, char ** argv) {
  char expr[256];
  int status;
  double result;

  while(1) {
    if(scanf("%254s", expr) == EOF) {
      break;
    }
    result = calculator(expr, &status);
    if(status == 0) {
      printf("OK: %s=%f\n", expr, result);
    }
    else {
      printf("ERROR\n");
    }
  }
}
