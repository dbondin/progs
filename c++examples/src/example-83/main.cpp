#include <iostream>
#include <vector>
#include <set>

#include "../utils/print_container.hxx"

using namespace std;

class X {
public:
	X(int i, const string & s, double d) {
		this->i = i;
		this->s = s;
		this->d = d;

		cout<<"X(int, string, double) called"<<endl;
	}

	X(const X & x) {
		this->i = x.i;
		this->s = x.s;
		this->d = x.d;

		cout<<"X(X&) called"<<endl;
	}

	int
	operator < (const X & x) const {
		return i < x.i;
	}

	friend
	ostream &
	operator << (ostream & os, const X & x) {
		return os<<"["<<x.i<<", '"<<x.s<<"', "<<x.d<<"]";
	}

private:
	int i;
	string s;
	double d;
};

int main(int argc, char **argv) {
	vector<int> v1;
	v1.push_back(6);
	v1.push_back(8);
	v1.push_back(2);
	v1.push_back(4);
	v1.push_back(10);
	v1.push_back(12);

	set<int> s1;

	s1.insert(v1.begin(), v1.end());

	print_container(v1);
	print_container(s1);

	set<X> s2;
	s2.insert(X(2, "world", 3.14));
	s2.insert(X(1, "hello", 0.5));

	s2.emplace(3, "!!!", 2.7);

	print_container(s2);

	return 0;
}
