template <class T>
Stack<T>::Stack(int size /* = DEFAULT_SIZE */) {
	_count = 0;
	_size = (size < MIN_SIZE) ? MIN_SIZE : size;
	_data = new T[_size];
}

template <class T>
void
Stack<T>::push(T value) throw(StackFullException) {
	if(_count == _size) {
		throw StackFullException();
	}
	_data[_count] = value;
	_count++;
}

template <class T>
T
Stack<T>::pop() throw(StackEmptyException) {
	if(0 == _count) {
		throw StackEmptyException();
	}
	_count--;
	return _data[_count];
}

template <class T>
int
Stack<T>::count() const {
	return _count;
}

template <class T>
int
Stack<T>::size() const {
	return _size;
}

template <class T>
Stack<T>::~Stack() {
	delete [] _data;
}

