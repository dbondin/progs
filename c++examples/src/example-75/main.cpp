#include <iostream>
#include <vector>
#include <list>

using namespace std;

template <class T=int>
class pair1 {
public:
	pair1(T first, T second) {
		this->first = first;
		this->second = second;
	}
	T first;
	T second;
};

template <class T, int count=10>
class test1 {
public:
	test1(T value) {
		this->value = value;
	}
	void print() {
		for(int i=0; i<count; i++) {
			cout<<value<<" ";
		}
		cout<<endl;
	}
private:
	T value;
};

//template <class T>
//void print_containter_elements(T & container) {
//
//}

template <class T>
void print_container_elements(T & v) {
	for(typename T::iterator iter = v.begin(); iter != v.end(); iter++) {
		cout<<*iter<<" ";
	}
	cout<<endl;
}


int main(int argc, char **argv) {

	pair1<double> p1(10.5, 20.400);

	cout<<p1.first<<" "<<p1.second<<endl;

	pair1<string> p2("str1", "str2");

	cout<<p2.first<<" "<<p2.second<<endl;

	test1<int> t1(50);
	t1.print();

	test1<string, 32> t2("hello");
	t2.print();

	vector<string> vs;
	vs.push_back("hello");
	vs.push_back("world");
	vs.push_back("111");
	print_container_elements< vector<string> >(vs);

	list<string> ls;
	ls.push_back("hello");
	ls.push_back("world");
	ls.push_back("111");
	print_container_elements(ls);

	return 0;
}
