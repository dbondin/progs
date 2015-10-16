#include <limits>
#include <iostream>
#include <algorithm>

using namespace std;

template <class T>
void doit() {
	//for(int i=0; i<numeric_limits<T>::max(); i++) {
		//...
	//}
	cout<<(unsigned long long)numeric_limits<T>::max()<<endl;
}

class Human {
public:
	Human(string _name, int _age) {
		this->name = _name;
		this->age = _age;
	}
	const string & get_name() const {
		return name;
	}
	int get_age() const {
		return age;
	}
	//int operator < (const Human & h) const {
	//	return this->age < h.age;
	//}
private:
	string name;
	int age;
};

int Human_compare(const Human & h1, const Human & h2) {
	return h1.get_age() < h2.get_age();
}

class HumanComparator {
public:
	int operator () (const Human & h1, const Human & h2) {
		return h1.get_age() < h2.get_age();
	}
};

int main(int argc, char **argv) {
	cout<<sizeof(int)<<endl;
	cout<<numeric_limits<int>::max()<<endl;

	doit<int>();
	doit<char>();

	cout<<"--------------"<<endl;

	cout<<min(5, 7)<<endl;
	Human h1("Дима", 36);
	Human h2("Саша", 29);
	cout<<h1.get_name()<<" "<<h2.get_name()<<endl;
	cout<<min(h1, h2, HumanComparator()).get_name()<<endl;
	cout<<min(h1, h2, [] (const Human & h1, const Human & h2) {
		return h1.get_age() < h2.get_age();
	}).get_name()<<endl;
	//minmax(h1, h2);

	return 0;
}
