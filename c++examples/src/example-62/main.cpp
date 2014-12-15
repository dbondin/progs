#include <set>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>
#include <cstdlib>
#include <unistd.h>
#include <time.h>

using namespace std;


int main(int argc, char **argv) {

	set<int> a;

	a.insert(1);
	a.insert(2);
	a.insert(3);
	a.insert(5);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	set<int> b;

	b.insert(1);
	b.insert(2);
	b.insert(4);
	b.insert(6);

	copy(b.begin(), b.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	set<int> c;

	set_union(a.begin(), a.end(), b.begin(), b.end(), inserter(c, c.begin()));

	copy(c.begin(), c.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	set<int> d;

	set_intersection(a.begin(), a.end(), b.begin(), b.end(), inserter(d, d.begin()));

	copy(d.begin(), d.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	set<int> e;

	set_difference(a.begin(), a.end(), b.begin(), b.end(), inserter(e, e.begin()));

	copy(e.begin(), e.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	return 0;
}

