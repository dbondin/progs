#include <algorithm>
#include <iostream>
#include <iterator>
#include <set>
#include <vector>

#include "../utils/print_container.hxx"

using namespace std;

class X {
public:

	X(int a = 0, int b = 0) {
		this->a = a;
		this->b = b;
	}

	X(const X & x) {
		this->a = x.a;
		this->b = x.b;
	}

//	bool operator < (const X x) const {
//		return this->a < x.a;
//	}

	friend ostream & operator<<(ostream & os, const X & x) {
		os << "[" << x.a << "; " << x.b << "]";
		return os;
	}

	int get_a() const {
		return a;
	}

	int get_b() const {
		return b;
	}

private:

//	X(const X & x) {
//		this->a = x.a;
//		this->b = x.b;
//	}

	int a;
	int b;
};

class X_less {
public:
	bool operator()(const X & x, const X & y) const {
		return x.get_a() < y.get_a();
	}
};

int main() {
	set<int, greater<int>> s1 { 3, 5, 2, 7, 5, 6, 9, 1, 4 };

	X x1(1, 2);
	X x2 = x1;

	set<X, X_less> s2 { X(1, 2), X(3, 4), X(0, 5), X(4, 10) };
	vector<X> s3(10);

	print_container(s1);
	print_container(s3);

	cout << x1 << " " << x2 << endl;

	print_container(s2);

	return 0;
}
