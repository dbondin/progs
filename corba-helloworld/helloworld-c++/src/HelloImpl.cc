
#include "HelloImpl.h"


// Implementation for interface Hello

char*
Hello_impl::world( const char* name )
  throw(
    ::CORBA::SystemException)

{
  char* retval;

  // add your implementation here
    // REMOVE  
    mico_throw(::CORBA::NO_IMPLEMENT());
    // REMOVE 

  return retval; 
}

