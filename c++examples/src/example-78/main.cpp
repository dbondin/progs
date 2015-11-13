#include <array>
#include <iostream>
#include <exception>

using namespace std;

int main(int argc, char **argv) {

	array<int, 5> a;

	a[0] = 10;
	a[1] = 20;
	a[10] = 100;

	cout<<a.at(0)<<endl;
	try {
		cout<<a.at(10)<<endl;
	}
	catch(out_of_range & ex) {
		cerr<<": ("<<endl;
	}
	cout<<a[10]<<endl;

	for(auto i = a.begin(); i != a.end(); i++) {
		cout<<"> "<<*i<<endl;
	}

	for(auto i = a.rbegin(); i != a.rend(); i++) {
		cout<<"r> "<<*i<<endl;
	}

	for(int v : a) {
		cout<<"v> "<<v<<endl;
	}

	array<char, 5> ca;
	ca[0] = 'H';
	ca[1] = 'e';
	ca[2] = 'l';
	ca[3] = 'l';
	ca[4] = 0;

	cout<<ca.data()<<endl;

	char * p = ca.data();
	p[1] = 'u'; p[3] = 'k';
	cout<<ca.data()<<endl;

	return 0;
}
