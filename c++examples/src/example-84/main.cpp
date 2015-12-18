#include <iostream>
#include <map>
#include <string>

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

template <class T>
void
print_map(T & m) {
	typename T::iterator i;
	for(i=m.begin(); i!=m.end(); ++i /*i++*/) {
		cout<<"["<<i->first<<" : "<<i->second<<"], ";
	}
	cout<<endl;
}

int main(int argc, char **argv) {
	map<int, string> m1;

	m1[1] = "hello";
	m1[2] = "world";

	m1.insert(std::pair<int, string>(3, "!!!"));
	m1.insert(decltype(m1)::value_type(4, "---"));
	m1.insert(map<int, string>::value_type(5, "+++"));
	m1.insert({6, "***"});

	print_map(m1);

	decltype(m1)::iterator i = m1.find(3);
	if(i != m1.end()) {
		cout<<"Found: "<<i->second<<endl;
	}

	for(int j=0; j<10; ++j) {
		cout<<j<<" ";
	}
	cout<<endl;

	int j=0;
	while(j<10) {
		cout<<j<<" ";
		++j;
	}
	cout<<endl;

	int x;

	j=10;
	x=j++;
	cout<<"j++ "<<x<<" j="<<j<<endl;

	j=10;
	x=++j;
	cout<<"++j "<<x<<" j="<<j<<endl;

	return 0;
}
