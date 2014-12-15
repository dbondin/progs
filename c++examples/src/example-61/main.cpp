#include <vector>
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

	vector<int> a;

	a.push_back(1);
	a.push_back(3);
	a.push_back(5);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	vector<int> b;

	b.push_back(2);
	b.push_back(4);
	b.push_back(6);

	copy(b.begin(), b.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	vector<int> c;

	merge(a.begin(), a.end(), b.begin(), b.end(), back_inserter(c));

	copy(c.begin(), c.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	return 0;
}

