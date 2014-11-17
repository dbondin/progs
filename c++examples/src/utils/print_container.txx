#include <iostream>

template<class T>
void print_container(T & c) {
	for (typename T::iterator i = c.begin(); i != c.end(); i++) {
		if (i != c.begin()) {
			std::cout << ", ";
		}
		std::cout << *i;
	}
	std::cout << std::endl;
}
