#include <algorithm>
#include <iterator>
#include <list>
#include <iostream>
using namespace std;
int main() {
	list<int> coll;
	for (int i = 1; i <= 6; ++i) {
		coll.push_front(i);
		coll.push_back(i);
	}
	cout << "pre: ";
	copy(coll.begin(), coll.end(), ostream_iterator<int>(cout, " "));
	cout << endl;
	list<int>::iterator e = remove(coll.begin(), coll.end(), 3);
	coll.erase(e, coll.end());
	cout << "post: ";
	copy(coll.begin(), coll.end(), ostream_iterator<int>(cout, " "));
	cout << endl;
}
