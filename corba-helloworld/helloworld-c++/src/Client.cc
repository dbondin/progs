#include "CORBA.h"
#include "helloworld.h"

int main(int argc, char ** argv) {

	CORBA::ORB_ptr orb = CORBA::ORB_init(argc, argv, "mico-local-orb");

	CORBA::ORB::ObjectIdList_ptr oidl = orb->list_initial_services();

	for(MICO_ULong i=0; i<oidl->length(); i++) {
		CORBA::String_var sv = (*oidl)[i];
		std::cout<<(char *)sv<<std::endl;
	}

	std::cout<<"Enter IOR:"<<std::endl;

	std::string ior;

	std::cin>>ior;

	HelloWorld::Hello_ptr hello = HelloWorld::Hello::_narrow(orb->string_to_object(ior.c_str()));

	std::cout<<hello->world("C++")<<std::endl;

	return 0;
}
