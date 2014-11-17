#include <list>
#include <iostream>

#include "../utils/print_container.hxx"

using namespace std;

class X {
public:
	X(int value) {
		this->value = value;
	}
	int get_value() const {
		return value;
	}
	void set_value(int value) {
		this->value = value;
	}
	friend ostream & operator << (ostream & os, const X & x) {
		os << x.value;
		return os;
	}
private:
	int value;
};

int main() {
	X x(123);

	list<X> l;
	//list<X*> ll;

	l.push_back(x);
	//ll.push_back(&x);

	cout<<x<<endl;
	print_container(l);

	x.set_value(321);

	cout<<x<<endl;
	print_container(l);

	//for(auto i = ll.begin(); i<ll.end(); i++) {
	//	cout<<"! "<<**i;
	//}
	//cout<<endl;

	return 0;
}
