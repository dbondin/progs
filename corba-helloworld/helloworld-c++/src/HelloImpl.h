
#ifndef __HELLOWORLD_IMPL_H__
#define __HELLOWORLD_IMPL_H__

#include "../idl-c++/helloworld.h"


// Implementation for interface Hello
class Hello_impl : virtual public POA_HelloWorld::Hello
{
  public:

    char* world( const char* name )
      throw(
        ::CORBA::SystemException)
    ;
};


#endif
