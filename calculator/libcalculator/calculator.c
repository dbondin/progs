#include "calculator.h"

double calculator(const char * expr, int * status) {
  double result = 0.0;
  int stat = 0;
  if(expr) {
    /* ... */
    result = 123.456;
  }
  if(status) {
    *status = stat;
  }
  return result;
}
