#pragma once

class MyException {
public:
	static const char * DEFAULT_MESSAGE;
	MyException(const char * message = DEFAULT_MESSAGE);
	virtual ~MyException();
	virtual const char * getMessage() const;
private:
	char * message;
};
