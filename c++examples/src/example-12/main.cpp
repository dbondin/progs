// example-12/main.cpp

#include <iostream>

void f() throw(int) {
	try {
		std::cout<<"f()"<<std::endl;
		throw 123;
	}
	catch(...) {
		std::cout<<"catch inside f()"<<std::endl;
		throw;
	}
}

int main(int argc, char ** argv) {
	try {
		f();
	}
	catch(int i) {
		std::cout<<"catch inside main(): "<<i<<std::endl;
	}
	return 0;
}
