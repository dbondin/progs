// example-11/main.cpp
#include <iostream>

void f() throw(int, double) {
	throw 1;
	//throw 1.1;
	//throw "hello";
}

int main(int argc, char ** argv) {

	try {
		f();
	}
	catch(int e) {
		std::cout<<"int caugth"<<std::endl;
	}
	catch(double e) {
		std::cout<<"double caugth"<<std::endl;
	}
	catch(const char * e) {
		std::cout<<"const char * caugth"<<std::endl;
	}

	return 0;
}
