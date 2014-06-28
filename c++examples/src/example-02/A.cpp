#include <iostream>

#include "A.h"

A::A() {
	std::cout<<"A::A() called"<<std::endl;

	this->value = 0;
}

A::A(const A & obj) {
	std::cout<<"A::A(const A &) called"<<std::endl;

	this->value = obj.value;
}

A::~A() {
	std::cout<<"A::~A() called (value="<<this->value<<")"<<std::endl;
}

void
A::set_value(int value) {
	this->value = value;
}

int
A::get_value() const {
	return this->value;
}
