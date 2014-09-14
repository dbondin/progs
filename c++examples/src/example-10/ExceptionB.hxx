#pragma once

#include "ExceptionA.hxx"

class ExceptionB : public ExceptionA {
public:
	virtual const char * getMessage();
};
