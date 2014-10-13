#include<iostream>
#include<list>
#include<string>

using namespace std;

template<class T>
void print_container(T & c) {
	for (typename T::iterator i = c.begin(); i != c.end(); i++) {
		if(i != c.begin()) {
			cout << ", ";
		}
		cout << *i;
	}
	cout << endl;
}

int main(int argc, char **argv) {


	list<string> ll;

	ll.push_back("hello");
	ll.push_back("world");
	ll.push_back("!!!");

	print_container(ll);

	return 0;
}
