#include <iostream>
#include <vector>

#define DEBUGPRINT(x) { cout<<"DEBUG: "<<(x)<<endl; }

using namespace std;

template <class T>
void swap1(T &x, T &y) {
	DEBUGPRINT("swap1-template")
	T tmp = x;
	x = y;
	y = tmp;
}

template<>
void swap1(int &x, int &y) {
	DEBUGPRINT("swap1-int")
	x ^= y;
	y ^= x;
	x ^= y;
}

template <class T1, class T2>
void print1(const T1 & a, const T2 & b) {
	cout<<a<<" "<<b<<endl;
}

int main(int argc, char **argv) {
	int i=1,j=5;
	cout<<"i="<<i<<" j="<<j<<endl;
	swap1<int>(i, j);
	cout<<"i="<<i<<" j="<<j<<endl;
	string s1="hello", s2="world";
	cout<<"s1="<<s1<<" s2="<<s2<<endl;
	swap1<string>(s1, s2);
	cout<<"s1="<<s1<<" s2="<<s2<<endl;
	double pi=3.14, e=2.7;
	print1<double, double>(pi, e);
	swap1<double>(pi, e);
	print1<double, double>(pi, e);

	print1<double, string>(pi, s2);
	return 0;
}
