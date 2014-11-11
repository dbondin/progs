#include<algorithm>
#include<vector>
#include<iostream>
#include<deque>

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

int main(int argc, char **argv) {

	vector<int> v;
	deque<int> d;

	v.push_back(2);
	v.push_back(5);
	v.push_back(7);
	v.push_back(1);
	v.push_back(3);
	v.push_back(9);
	v.push_back(4);
	v.push_back(8);
	//v.push_back(6);

	d.push_back(2);
	d.push_back(5);
	d.push_back(7);
	d.push_back(1);
	d.push_back(3);
	d.push_back(9);
	d.push_back(4);
	d.push_back(8);
	d.push_back(0);

	print_container(v);
	print_container(d);

	cout<<equal(v.begin(), v.end(), d.begin())<<endl;

	return 0;
}
