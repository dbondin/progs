#ifndef STACK_HXX_
#define STACK_HXX_

class StackFullException {
};

class StackEmptyException {
};

template <class T=int>
class Stack {
public:
	static const int DEFAULT_SIZE = 128;
	static const int MIN_SIZE = 16;

	Stack(int size = DEFAULT_SIZE);
	virtual void push(T value) throw(StackFullException);
	virtual T pop() throw(StackEmptyException);
	virtual int count() const;
	virtual int size() const;
	virtual ~Stack();
private:
	T * _data;
	int _size;
	int _count;
};

#include "Stack.tcc"

#endif /* STACK_HXX_ */
