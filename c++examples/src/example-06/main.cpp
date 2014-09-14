// example-06/main.cpp

#include<iostream>

int main(int argc, char ** argv) {

	try {
		std::cout<<"action 1"<<std::endl;
		//throw 123;
		//throw 123.456;
		//throw "hello";
		std::cout<<"action 2"<<std::endl;
	}
	catch (int e) {
		std::cout<<"int exception caught: "<<e<<std::endl;
	}
	catch (double e) {
		std::cout<<"double exception caught: "<<e<<std::endl;
	}
	catch (const char * e) {
		std::cout<<"const char * exception caught: "<<e<<std::endl;
	}

	return 0;
}
