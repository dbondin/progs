#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>

#include <cmath>

using namespace std;

bool aaa(int elem) {
	return elem>4;
}

class Bbb {
public:
	bool operator () (int elem) {
		return elem%2==0;
	}
};

class Coord {
public:
	Coord(double _x = 0.0, double _y = 0.0, double _z = 0.0) : x(_x), y(_y), z(_z) {

	};
	double get_x() const {
		return x;
	}
	double get_y() const {
		return y;
	}
	double get_z() const {
		return z;
	}
	friend ostream & operator << (ostream & os, const Coord & c) {
		os<<"["<<c.x<<","<<c.y<<","<<c.z<<"]";
		return os;
	}
private:
	double x;
	double y;
	double z;
};

int main() {
	vector<int> coll;
	int num;

	for(int i=1; i<=9; i++) {
		coll.push_back(i);
	}

	num = count(coll.cbegin(), coll.cend(), 4);
	cout << "number of elements equal to 4:" << num << endl;
	num = count_if(coll.cbegin(), coll.cend(), Bbb());
	cout << "number of elements with even value: " << num << endl;
	num = count_if(coll.cbegin(), coll.cend(), aaa);
	cout << "number of elements greater than 4:" << num << endl;

	coll.push_back(1);

	vector<int>::iterator res = min_element(coll.begin(), coll.end(),
			[](int a, int b) {
		return a <= b;
	});
	cout<<"min element = " << *res << endl;
	if(res == coll.begin()) {
		cout << "this is first one" << endl;
	}
	else {
		cout << "this is NOT first one" << endl;
	}

	vector<Coord> vc;

	vc.push_back(Coord(1, 0, 0));
	vc.push_back(Coord(0, 1, 0));
	vc.push_back(Coord(0.5, .1, .1));
	vc.push_back(Coord(0, 0, 1));

	vector<Coord>::iterator res2 = min_element(vc.begin(), vc.end(),
			[](const Coord & a, const Coord & b) {
				return sqrt(a.get_x() * a.get_x() + a.get_y() * a.get_y() + a.get_z() * a.get_z()) <
						sqrt(b.get_x() * b.get_x() + b.get_y() * b.get_y() + b.get_z() * b.get_z());
			}
	);
	cout << "min coord: " << *res2 << endl;

	copy(vc.begin(), vc.end(), ostream_iterator<Coord>(cout, " "));
}
