#include<iostream>

template <class T>
class DynArr {
public:
	DynArr(int size = 10) {
		_size = size;
		_data = new T[_size];
	}
	~DynArr() {
		std::cout<<"~DynArr() called"<<std::endl;
		delete [] _data;
	}
	T get(int idx) {
		if(idx < 0 || idx >= _size) {
			throw "bad index";
		}
		return _data[idx];
	}
	void set(int idx, T & value) {
		if(idx < 0 || idx >= _size) {
			throw "bad index";
		}
		_data[idx] = value;
	}
	void resize(int size) {
		T * new_data = new T[size];
		int min_size = (size < _size) ? size : _size;
		for(int i=0; i<min_size; i++) {
			new_data[i] = _data[i];
		}
		delete [] _data;
		_data = new_data;
		_size = size;
	}
	T & operator[](int idx) {
		if(idx < 0 || idx >= _size) {
			throw "bad index";
		}
		return _data[idx];
	}
private:
	int _size;
	T * _data;
};

int main(int argc, char **argv) {
	DynArr<int> a;

	for(int i=0; i<10; i++) {
		a[i] = i*i;
	}

	for(int i=0; i<10; i++) {
		std::cout<<a[i]<<std::endl;
	}

	a.resize(11);
	a[10] = 111;
	for(int i=0; i<11; i++) {
		std::cout<<a[i]<<std::endl;
	}

	std::cout<<"one"<<std::endl;
	{
		DynArr<float> ff;
		ff[1] = 10.0;
	}
	std::cout<<"two"<<std::endl;
}
