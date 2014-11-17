#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <iterator>
#include <string>

using namespace std;

class Data {

public:

	Data(int __i = 0, string __s = "") : i(__i), s(__s) {
	}

	friend ostream & operator << (ostream & os, const Data & __d) {
		os << "[" << __d.s << ": " << __d.i << "]";
		return os;
	}

private:

	int i;
	string s;
};

Data pair2data(const pair<string, int> & __p) {
	return Data(__p.second, __p.first);
}

class Pair2Data {
public:
	Data operator() (const pair<string, int> & __p) {
		return Data(__p.second, __p.first);
	}
};

int main(int argc, char ** argv) {

	map<string, int> m;
	vector<Data> v;
	vector<Data> z;
	vector<Data> x;

	m["hello"] = 1;
	m["world"] = 2;
	m["cat"] = 3;
	m["dog"] = 0;

	// Using lambda
	transform(m.begin(), m.end(),
		back_inserter(v),
		[] (const pair<string, int> & __p) {
			return Data(__p.second, __p.first);
		}
	);

	copy(v.begin(), v.end(), ostream_iterator<Data>(cout, " "));
	cout << endl;

	// Using function
	transform(m.begin(), m.end(),
		back_inserter(z),
		pair2data
	);
	copy(z.begin(), z.end(), ostream_iterator<Data>(cout, " "));
	cout << endl;

	// Using functor class
	transform(m.begin(), m.end(),
		back_inserter(x),
		Pair2Data()
	);
	copy(x.begin(), x.end(), ostream_iterator<Data>(cout, " "));
	cout << endl;

	return 0;
}
