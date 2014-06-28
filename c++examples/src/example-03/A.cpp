#include <iostream>

#include "A.h"

A::A() {
	std::cout<<"A::A() called"<<std::endl;

	this->value = 0;
	this->array = new int[ARRAY_SIZE];
}

A::~A() {
	std::cout<<"A::~A() called (value="<<this->value<<")"<<std::endl;

	delete [] this->array;
}

void
A::set_value(int value) {
	this->value = value;
}

int
A::get_value() const {
	return this->value;
}
