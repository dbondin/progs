#include <algorithm>
#include <iterator>
#include <list>
#include <vector>
#include <deque>
#include <set>
#include <iostream>
using namespace std;

template<class T>
void print_container(T & c) {
	for (typename T::iterator i = c.begin(); i != c.end(); i++) {
		if (i != c.begin()) {
			cout << ", ";
		}
		cout << *i;
	}
	cout << endl;
}

int main() {
	list<int> coll1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	print_container(coll1);

	vector<int> coll2;
	//copy(coll1.begin(), coll1.end(), coll2.begin());
	copy(coll1.begin(), coll1.end(), back_inserter(coll2));

	//back_inserter(c):
	//c.begin() = value
	//c.push_back(value);

	print_container(coll2);

	deque<int> coll3;
	copy(coll1.begin(), coll1.end(), front_inserter(coll3));

	print_container(coll3);

	set<int> coll4;
	copy(coll1.begin(), coll1.end(), inserter(coll4, coll4.begin())); // destination

	print_container(coll4);
}
