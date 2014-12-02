#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>

#include <cmath>

using namespace std;

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
	bool operator == (const Coord & c) {
		return x == c.x && y == c.y && z == c.z;
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
	vector<Coord> coll;

	coll.push_back(Coord(1, 2, 3));
	coll.push_back(Coord(1, 2, 4));
	coll.push_back(Coord(1, 7, 2));
	coll.push_back(Coord(1, 7, 2));
	coll.push_back(Coord(1, 2, 5));
	coll.push_back(Coord(1, 2, 6));
	coll.push_back(Coord(1, 2, 7));
	coll.push_back(Coord(1, 7, 2));
	coll.push_back(Coord(1, 7, 2));
	coll.push_back(Coord(1, 7, 2));
	coll.push_back(Coord(7, 2, 1));
	coll.push_back(Coord(0, 2, 5));

	auto pos = search_n(coll.begin(), coll.end(), 3, Coord(1, 7, 2));
	if(pos != coll.end()) {
		cout<<"found"<<endl;
	}
	else {
		cout<<"not found"<<endl;
	}
}
