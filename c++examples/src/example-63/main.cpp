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

	a.push_back(4);
	a.push_back(2);
	a.push_back(3);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	double r = accumulate(a.begin(), a.end(), 1, [] (const double & x, const double & y) {return x * y;});

	cout<<r<<endl;

	vector<double> a1;
	vector<double> b1;

	a1.push_back(2);
	a1.push_back(3);

	b1.push_back(20);
	b1.push_back(30);


	double x = inner_product(a1.begin(), a1.end(), b1.begin(), 0);

	cout<<x<<endl;

	vector<double> a2;

	a2.push_back(3);
	a2.push_back(4);

	cout<<sqrt(inner_product(a2.begin(), a2.end(), a2.begin(), 0))<<endl;

	return 0;
}

