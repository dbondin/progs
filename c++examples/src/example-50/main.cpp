#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>

using namespace std;

int main(int argc, char **argv) {

	vector<int> a;
	vector<int> b;
	vector<string> c;

	a.push_back(1);
	a.push_back(2);
	a.push_back(3);
	a.push_back(4);

	transform(a.begin(), a.end(), back_inserter(b), [] (int x) {return x*x;});

	copy(b.begin(), b.end(), ostream_iterator<int>(cout, " "));

	transform(a.begin(), a.end(), back_inserter(c), [] (int x)
			{
				string s;
				for(int i=0; i<x; i++) {
					s += '+';
				}
				return s;
			});

	copy(c.begin(), c.end(), ostream_iterator<string>(cout, " "));
	cout<<endl;

	vector<int> x;
	vector<int> y;
	vector<int> z;

	x.push_back(12);
	x.push_back(13);
	x.push_back(14);

	y.push_back(65);
	y.push_back(67);
	y.push_back(68);

	transform(x.begin(), x.end(), y.begin(), back_inserter(z), [] (int _x, int _y)
			{
				return _x * _y;
			});

	copy(z.begin(), z.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	return 0;
}

