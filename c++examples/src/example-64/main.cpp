#include <set>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>
#include <cstdlib>
#include <unistd.h>
#include <time.h>
#include <numeric>

using namespace std;


int main(int argc, char **argv) {

	vector<double> a;

	a.push_back(10.0);
	a.push_back(+1.0);
	a.push_back(+2.0);
	a.push_back(-10);

	vector<double> b;

	partial_sum(a.begin(), a.end(), back_inserter(b));

	copy(a.begin(), a.end(), ostream_iterator<double>(cout, " "));
	cout<<endl;

	copy(b.begin(), b.end(), ostream_iterator<double>(cout, " "));
	cout<<endl;

	vector<double> c;

	adjacent_difference(b.begin(), b.end(), back_inserter(c));

	copy(c.begin(), c.end(), ostream_iterator<double>(cout, " "));
	cout<<endl;


	return 0;
}

