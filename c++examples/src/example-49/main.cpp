#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>

using namespace std;

struct data {
	string s;
	int i;
	friend ostream & operator << (ostream & os, const data & d) {
		cout<<"[s="<<d.s<<",i="<<d.i<<"]";
		return os;
	}
};

int main(int argc, char **argv) {

	map<string, int> m;

	m["hello"] = 1;
	m["world"] = 10;
	m["helicopter"] = 4;

	vector<data> v;

	transform(m.begin(), m.end(), back_inserter(v),
			[](const pair<string, int> & p) {
		data d;
		d.s = p.first;
		d.i = p.second;
		return d;
	});

	sort(v.begin(), v.end(), [](const data & a, const data & b) {return a.i < b.i;});

	copy(v.begin(), v.end(), ostream_iterator<data>(cout, " "));

	return 0;
}

