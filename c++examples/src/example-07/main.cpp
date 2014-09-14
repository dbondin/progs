// example-07/main.cpp

#include<iostream>

int main(int argc, char ** argv) {
	try {
		std::cout<<"action 1"<<std::endl;
		try {
			std::cout<<"action 2"<<std::endl;
			throw 123;
			//throw 123.456;
			std::cout<<"action 3"<<std::endl;
		}
		catch(int e) {
			std::cout<<"int exception caught (in): "<<e<<std::endl;
		}
		throw 321;
		std::cout<<"action 4"<<std::endl;
	}
	catch(int e) {
		std::cout<<"int exception caught (out): "<<e<<std::endl;
	}
	catch(double e) {
		std::cout<<"double exception caught (out): "<<e<<std::endl;
	}

	return 0;
}
