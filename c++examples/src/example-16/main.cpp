#include<iostream>
#include<string>
#include<sstream>
#include<cmath>

using namespace std;

string to_str(double d) {
	ostringstream os;
	os<<d;
	return os.str();
}

/* Complex Number */
class CN {
public:
	CN(double r = 0.0, double i = 0.0) {
		this->r = r;
		this->i = i;
	};
	string to_string() {
		string result = "";
		result += to_str(r);
		if(i>=0) {
			result += '+';
		}
		result += to_str(i);
		result += 'i';
		return result;
	}
	bool operator > (double & x) {
		return sqrt(r*r + i*i) > x;
	}
private:
	double r; // Real
	double i; // Imaginary
};

template <class T>
void exchange(T & a, T & b) {
	T tmp = a;
	a = b;
	b = tmp;
}

void exchange(int & i, int & j) {
	i ^= j;
	j ^= i;
	i ^= j;
}

template <class T1, class T2>
bool fun1(T1 x, T2 y) {
	return x > y;
}

int main(int argc, char **argv) {
	int x=10, y=20;
	string s="hello", t="world";

	cout<<x<<" "<<y<<endl;
	exchange(x, y);
	cout<<x<<" "<<y<<endl;

	cout<<s<<" "<<t<<endl;
	exchange(s, t);
	cout<<s<<" "<<t<<endl;

	CN c1(1, 1), c2(2, 1);
	cout<<c1.to_string()<<" "<<c2.to_string()<<endl;
	exchange(c1, c2);
	cout<<c1.to_string()<<" "<<c2.to_string()<<endl;

	cout<<fun1(c2, 2.0)<<endl;

	return 0;
}
