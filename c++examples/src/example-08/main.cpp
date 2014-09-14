// example-08/main.cpp

#include<iostream>

void fun() {
	std::cout<<"fun() begin"<<std::endl;
	throw "error running fun()";
	std::cout<<"fun() end"<<std::endl;
}

int main(int argc, char ** argv) {
	try {
		std::cout<<"action 1"<<std::endl;
		fun();
		std::cout<<"action 2"<<std::endl;
	}
	catch(const char * e) {
		std::cout<<"const char * exception caught: "<<e<<std::endl;
	}

	return 0;
}
