#include<cstring>
#include"MyException.hxx"

const char *
MyException::DEFAULT_MESSAGE = ":(";

MyException::MyException(int code /* = 0 */,
		const char * message /* = DEFAULT_MESSAGE */) {
	this->code = code;
	if(message == DEFAULT_MESSAGE || message == NULL) {
		this->message = const_cast<char *>(DEFAULT_MESSAGE);
	}
	else {
		int size = strlen(message) + 1;
		this->message = new char[size];
		strncpy(this->message, message, size);
	}
}

MyException::~MyException() {
	if(this->message != DEFAULT_MESSAGE) {
		delete [] this->message;
	}
}

const char *
MyException::getMessage() const {
	return this->message;
}

int
MyException::getCode() const {
	return this->code;
}
