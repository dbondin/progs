/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <CORBA.h>
#include <mico/throw.h>

#ifndef __HELLOWORLD_H__
#define __HELLOWORLD_H__






namespace HelloWorld
{

class Hello;
typedef Hello *Hello_ptr;
typedef Hello_ptr HelloRef;
typedef ObjVar< Hello > Hello_var;
typedef ObjOut< Hello > Hello_out;

}






namespace HelloWorld
{


/*
 * Base class and common definitions for interface Hello
 */

class Hello : 
  virtual public CORBA::Object
{
  public:
    virtual ~Hello();

    #ifdef HAVE_TYPEDEF_OVERLOAD
    typedef Hello_ptr _ptr_type;
    typedef Hello_var _var_type;
    #endif

    static Hello_ptr _narrow( CORBA::Object_ptr obj );
    static Hello_ptr _narrow( CORBA::AbstractBase_ptr obj );
    static Hello_ptr _duplicate( Hello_ptr _obj )
    {
      CORBA::Object::_duplicate (_obj);
      return _obj;
    }

    static Hello_ptr _nil()
    {
      return 0;
    }

    virtual void *_narrow_helper( const char *repoid );

    virtual char* world( const char* name ) = 0;

  protected:
    Hello() {};
  private:
    Hello( const Hello& );
    void operator=( const Hello& );
};

// Stub for interface Hello
class Hello_stub:
  virtual public Hello
{
  public:
    virtual ~Hello_stub();
    char* world( const char* name );

  private:
    void operator=( const Hello_stub& );
};

#ifndef MICO_CONF_NO_POA

class Hello_stub_clp :
  virtual public Hello_stub,
  virtual public PortableServer::StubBase
{
  public:
    Hello_stub_clp (PortableServer::POA_ptr, CORBA::Object_ptr);
    virtual ~Hello_stub_clp ();
    char* world( const char* name );

  protected:
    Hello_stub_clp ();
  private:
    void operator=( const Hello_stub_clp & );
};

#endif // MICO_CONF_NO_POA

}


#ifndef MICO_CONF_NO_POA



namespace POA_HelloWorld
{

class Hello : virtual public PortableServer::StaticImplementation
{
  public:
    virtual ~Hello ();
    HelloWorld::Hello_ptr _this ();
    bool dispatch (CORBA::StaticServerRequest_ptr);
    virtual void invoke (CORBA::StaticServerRequest_ptr);
    virtual CORBA::Boolean _is_a (const char *);
    virtual CORBA::InterfaceDef_ptr _get_interface ();
    virtual CORBA::RepositoryId _primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr);

    virtual void * _narrow_helper (const char *);
    static Hello * _narrow (PortableServer::Servant);
    virtual CORBA::Object_ptr _make_stub (PortableServer::POA_ptr, CORBA::Object_ptr);

    virtual char* world( const char* name ) = 0;

  protected:
    Hello () {};

  private:
    Hello (const Hello &);
    void operator= (const Hello &);
};

}


#endif // MICO_CONF_NO_POA

extern CORBA::StaticTypeInfo *_marshaller_HelloWorld_Hello;

#endif
