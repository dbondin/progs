#include<iostream>
#include"MyException.hxx"

int main(int argc, char ** argv) {
	try {
		throw MyException();
		//throw MyException(MyException::DEFAULT_MESSAGE);
		//throw MyException(5, "You would make a good Dalek!!!");
	}
	catch(MyException & e) {
		std::cout<<"MyException caugth: "<<e.getCode()<<" "<<e.getMessage()<<std::endl;
	}
	return 0;
}
