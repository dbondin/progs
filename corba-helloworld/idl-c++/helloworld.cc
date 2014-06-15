/*
 *  MICO --- an Open Source CORBA implementation
 *  Copyright (c) 1997-2006 by The Mico Team
 *
 *  This file was automatically generated. DO NOT EDIT!
 */

#include <helloworld.h>


using namespace std;

//--------------------------------------------------------
//  Implementation of stubs
//--------------------------------------------------------

/*
 * Base interface for class Hello
 */

HelloWorld::Hello::~Hello()
{
}

void *
HelloWorld::Hello::_narrow_helper( const char *_repoid )
{
  if( strcmp( _repoid, "IDL:HelloWorld/Hello:1.0" ) == 0 )
    return (void *)this;
  return NULL;
}

HelloWorld::Hello_ptr
HelloWorld::Hello::_narrow( CORBA::Object_ptr _obj )
{
  HelloWorld::Hello_ptr _o;
  if( !CORBA::is_nil( _obj ) ) {
    void *_p;
    if( (_p = _obj->_narrow_helper( "IDL:HelloWorld/Hello:1.0" )))
      return _duplicate( (HelloWorld::Hello_ptr) _p );
    if (!strcmp (_obj->_repoid(), "IDL:HelloWorld/Hello:1.0") || _obj->_is_a_remote ("IDL:HelloWorld/Hello:1.0")) {
      _o = new HelloWorld::Hello_stub;
      _o->CORBA::Object::operator=( *_obj );
      return _o;
    }
  }
  return _nil();
}

HelloWorld::Hello_ptr
HelloWorld::Hello::_narrow( CORBA::AbstractBase_ptr _obj )
{
  return _narrow (_obj->_to_object());
}

class _Marshaller_HelloWorld_Hello : public ::CORBA::StaticTypeInfo {
    typedef HelloWorld::Hello_ptr _MICO_T;
  public:
    ~_Marshaller_HelloWorld_Hello();
    StaticValueType create () const;
    void assign (StaticValueType dst, const StaticValueType src) const;
    void free (StaticValueType) const;
    void release (StaticValueType) const;
    ::CORBA::Boolean demarshal (::CORBA::DataDecoder&, StaticValueType) const;
    void marshal (::CORBA::DataEncoder &, StaticValueType) const;
};


_Marshaller_HelloWorld_Hello::~_Marshaller_HelloWorld_Hello()
{
}

::CORBA::StaticValueType _Marshaller_HelloWorld_Hello::create() const
{
  return (StaticValueType) new _MICO_T( 0 );
}

void _Marshaller_HelloWorld_Hello::assign( StaticValueType d, const StaticValueType s ) const
{
  *(_MICO_T*) d = ::HelloWorld::Hello::_duplicate( *(_MICO_T*) s );
}

void _Marshaller_HelloWorld_Hello::free( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
  delete (_MICO_T*) v;
}

void _Marshaller_HelloWorld_Hello::release( StaticValueType v ) const
{
  ::CORBA::release( *(_MICO_T *) v );
}

::CORBA::Boolean _Marshaller_HelloWorld_Hello::demarshal( ::CORBA::DataDecoder &dc, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj;
  if (!::CORBA::_stc_Object->demarshal(dc, &obj))
    return FALSE;
  *(_MICO_T *) v = ::HelloWorld::Hello::_narrow( obj );
  ::CORBA::Boolean ret = ::CORBA::is_nil (obj) || !::CORBA::is_nil (*(_MICO_T *)v);
  ::CORBA::release (obj);
  return ret;
}

void _Marshaller_HelloWorld_Hello::marshal( ::CORBA::DataEncoder &ec, StaticValueType v ) const
{
  ::CORBA::Object_ptr obj = *(_MICO_T *) v;
  ::CORBA::_stc_Object->marshal( ec, &obj );
}

::CORBA::StaticTypeInfo *_marshaller_HelloWorld_Hello;


/*
 * Stub interface for class Hello
 */

HelloWorld::Hello_stub::~Hello_stub()
{
}

#ifndef MICO_CONF_NO_POA

void *
POA_HelloWorld::Hello::_narrow_helper (const char * repoid)
{
  if (strcmp (repoid, "IDL:HelloWorld/Hello:1.0") == 0) {
    return (void *) this;
  }
  return NULL;
}

POA_HelloWorld::Hello *
POA_HelloWorld::Hello::_narrow (PortableServer::Servant serv) 
{
  void * p;
  if ((p = serv->_narrow_helper ("IDL:HelloWorld/Hello:1.0")) != NULL) {
    serv->_add_ref ();
    return (POA_HelloWorld::Hello *) p;
  }
  return NULL;
}

HelloWorld::Hello_stub_clp::Hello_stub_clp ()
{
}

HelloWorld::Hello_stub_clp::Hello_stub_clp (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
  : CORBA::Object(*obj), PortableServer::StubBase(poa)
{
}

HelloWorld::Hello_stub_clp::~Hello_stub_clp ()
{
}

#endif // MICO_CONF_NO_POA

char* HelloWorld::Hello_stub::world( const char* _par_name )
{
  CORBA::StaticAny _sa_name( CORBA::_stc_string, &_par_name );
  char* _res = NULL;
  CORBA::StaticAny __res( CORBA::_stc_string, &_res );

  CORBA::StaticRequest __req( this, "world" );
  __req.add_in_arg( &_sa_name );
  __req.set_result( &__res );

  __req.invoke();

  mico_sii_throw( &__req, 
    0);
  return _res;
}


#ifndef MICO_CONF_NO_POA

char*
HelloWorld::Hello_stub_clp::world( const char* _par_name )
{
  PortableServer::Servant _serv = _preinvoke ();
  if (_serv) {
    POA_HelloWorld::Hello * _myserv = POA_HelloWorld::Hello::_narrow (_serv);
    if (_myserv) {
      char* __res;

      #ifdef HAVE_EXCEPTIONS
      try {
      #endif
        __res = _myserv->world(_par_name);
      #ifdef HAVE_EXCEPTIONS
      }
      catch (...) {
        _myserv->_remove_ref();
        _postinvoke();
        throw;
      }
      #endif

      _myserv->_remove_ref();
      _postinvoke ();
      return __res;
    }
    _postinvoke ();
  }

  return HelloWorld::Hello_stub::world(_par_name);
}

#endif // MICO_CONF_NO_POA

struct __tc_init_HELLOWORLD {
  __tc_init_HELLOWORLD()
  {
    _marshaller_HelloWorld_Hello = new _Marshaller_HelloWorld_Hello;
  }

  ~__tc_init_HELLOWORLD()
  {
    delete static_cast<_Marshaller_HelloWorld_Hello*>(_marshaller_HelloWorld_Hello);
  }
};

static __tc_init_HELLOWORLD __init_HELLOWORLD;

//--------------------------------------------------------
//  Implementation of skeletons
//--------------------------------------------------------

// PortableServer Skeleton Class for interface HelloWorld::Hello
POA_HelloWorld::Hello::~Hello()
{
}

::HelloWorld::Hello_ptr
POA_HelloWorld::Hello::_this ()
{
  CORBA::Object_var obj = PortableServer::ServantBase::_this();
  return ::HelloWorld::Hello::_narrow (obj);
}

CORBA::Boolean
POA_HelloWorld::Hello::_is_a (const char * repoid)
{
  if (strcmp (repoid, "IDL:HelloWorld/Hello:1.0") == 0) {
    return TRUE;
  }
  return FALSE;
}

CORBA::InterfaceDef_ptr
POA_HelloWorld::Hello::_get_interface ()
{
  CORBA::InterfaceDef_ptr ifd = PortableServer::ServantBase::_get_interface ("IDL:HelloWorld/Hello:1.0");

  if (CORBA::is_nil (ifd)) {
    mico_throw (CORBA::OBJ_ADAPTER (0, CORBA::COMPLETED_NO));
  }

  return ifd;
}

CORBA::RepositoryId
POA_HelloWorld::Hello::_primary_interface (const PortableServer::ObjectId &, PortableServer::POA_ptr)
{
  return CORBA::string_dup ("IDL:HelloWorld/Hello:1.0");
}

CORBA::Object_ptr
POA_HelloWorld::Hello::_make_stub (PortableServer::POA_ptr poa, CORBA::Object_ptr obj)
{
  return new ::HelloWorld::Hello_stub_clp (poa, obj);
}

bool
POA_HelloWorld::Hello::dispatch (CORBA::StaticServerRequest_ptr __req)
{
  #ifdef HAVE_EXCEPTIONS
  try {
  #endif
    if( strcmp( __req->op_name(), "world" ) == 0 ) {
      CORBA::String_var _par_name;
      CORBA::StaticAny _sa_name( CORBA::_stc_string, &_par_name._for_demarshal() );

      char* _res;
      CORBA::StaticAny __res( CORBA::_stc_string, &_res );
      __req->add_in_arg( &_sa_name );
      __req->set_result( &__res );

      if( !__req->read_args() )
        return true;

      _res = world( _par_name.inout() );
      __req->write_results();
      CORBA::string_free( _res );
      return true;
    }
  #ifdef HAVE_EXCEPTIONS
  } catch( CORBA::SystemException_catch &_ex ) {
    __req->set_exception( _ex->_clone() );
    __req->write_results();
    return true;
  } catch( ... ) {
    CORBA::UNKNOWN _ex (CORBA::OMGVMCID | 1, CORBA::COMPLETED_MAYBE);
    __req->set_exception (_ex->_clone());
    __req->write_results ();
    return true;
  }
  #endif

  return false;
}

void
POA_HelloWorld::Hello::invoke (CORBA::StaticServerRequest_ptr __req)
{
  if (dispatch (__req)) {
      return;
  }

  CORBA::Exception * ex = 
    new CORBA::BAD_OPERATION (0, CORBA::COMPLETED_NO);
  __req->set_exception (ex);
  __req->write_results();
}

