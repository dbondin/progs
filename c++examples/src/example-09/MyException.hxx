#pragma once

class MyException {
public:
	static const char * DEFAULT_MESSAGE;
	MyException(int code = 0, const char * message = DEFAULT_MESSAGE);
	virtual ~MyException();
	virtual const char * getMessage() const;
	virtual int getCode() const;
private:
	int code;
	char * message;
};
