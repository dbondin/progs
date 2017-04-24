#include <iostream>

#include "simplelist.h"

int main(int argc, char ** argv) {

  dbondin::SimpleList<int> sl;

  sl.push_front(1);
  sl.push_front(2);
  sl.push_front(3);

  for(dbondin::SimpleList<int>::iterator i = sl.begin(); i != sl.end(); ++i) {
    std::cout<<">> "<<*i<<std::endl;
  }
  
  return 0;
}
