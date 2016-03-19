#include<vector>
#include<list>
#include<iostream>
#include<algorithm>
#include<iterator>
#include<cmath>

using namespace std;

template <class T>
void pr(T & t) {
	::copy(t.begin(), t.end(), ostream_iterator<typename T::value_type>(cout, "; "));
	cout<<endl;
}

class cnum {
public:
	cnum() {
		_r=0.0;
		_i=0.0;
	}
	cnum(const double & r, const double & i) {
		_r=r;
		_i=i;
	}
	double & r() {
		return _r;
	}
	double & i() {
		return _i;
	}
	friend
	ostream &
	operator << (ostream & os, const cnum & x) {
		return os<<'('<<x._r<<", "<<x._i<<")";
	}
private:
	double _r;
	double _i;
};

int main(int argc, char **argv) {

	vector<cnum> v1 = {{0, 0}, {1, 0}, {0, 1}, {1, 1}};

	pr(v1);

	auto new_end = ::unique(v1.begin(), v1.end(),
			[](cnum & a, cnum & b) {
		return (a.r() * a.r() + a.i() * a.i()) == (b.r() * b.r() + b.i() * b.i());
	});
	v1.erase(new_end);

	pr(v1);

	::random_shuffle(v1.begin(), v1.end());
	pr(v1);

	vector<int> v2 = {1, 2, 2, 2, 3, 4, 5, 3, 2, 3, 1};

	::partition(v2.begin(), v2.end(), [](const int & x) {return x<=2;});

	pr(v2);

	return 0;
}
