#include<algorithm>
#include<vector>
#include<iostream>

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

	v.push_back(2);
	v.push_back(5);
	v.push_back(7);
	v.push_back(1);
	v.push_back(3);
	v.push_back(9);
	v.push_back(4);
	v.push_back(8);
	v.push_back(6);

	print_container(v);

	vector<int>::iterator vi = v.begin();
	vi++; vi++; vi++;

	sort(vi, v.end());
	print_container(v);

	return 0;
}
