#include<iostream>
#include"MyException.hxx"

int main(int argc, char ** argv) {
	try {
		throw MyException();
		//throw MyException(MyException::DEFAULT_MESSAGE);
		//throw MyException("You would make a good Dalek!!!");
	}
	catch(MyException & e) {
		std::cout<<"MyException caugth: "<<e.getMessage()<<std::endl;
	}
	return 0;
}
