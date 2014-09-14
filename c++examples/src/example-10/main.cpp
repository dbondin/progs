#include <iostream>
#include "ExceptionA.hxx"
#include "ExceptionB.hxx"

int main(int argc, char ** argv) {

	try {
		throw ExceptionB();
	}
	catch(ExceptionA & e) {
		std::cout<<"catch(A): "<<e.getMessage()<<std::endl;
	}
	catch(ExceptionB & e) {
		std::cout<<"catch(B): "<<e.getMessage()<<std::endl;
	}

	try {
		throw ExceptionB();
	}
	catch(ExceptionB & e) {
		std::cout<<"catch(B): "<<e.getMessage()<<std::endl;
	}
	catch(ExceptionA & e) {
		std::cout<<"catch(A): "<<e.getMessage()<<std::endl;
	}

	return 0;
}
