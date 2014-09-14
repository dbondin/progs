// example-13/main.cpp
#include <iostream>
#include <exception>
#include <cstdlib>

void (* old_terminate_handler)() = NULL;

void my_terminate_handler() {
	std::cout<<"Game Over !!!"<<std::endl;
	if(old_terminate_handler != NULL) {
		old_terminate_handler();
	}
}

int main(int argc, char ** argv) {

	old_terminate_handler = std::set_terminate(my_terminate_handler);

	throw 1;

	return 0;
}
