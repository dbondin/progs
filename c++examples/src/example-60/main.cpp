#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>
#include <cstdlib>
#include <unistd.h>
#include <time.h>

using namespace std;


//TODO: Почему-то оно работает в обратную сторону.
bool my_check(const string & a, const string & b) {
	int size = (a.length() > b.length()) ? b.length() : a.length();
	for(int i=0; i<size; i++) {
		if(a[i] != b[i]) {
			return false;
		}
	}
	return true;
}

int main(int argc, char **argv) {

	vector<string> c;

	c.push_back("арбуз");
	c.push_back("банан");
	c.push_back("барабан");
	c.push_back("базука");
	c.push_back("бандана");
	c.push_back("банда");
	c.push_back("виски");
	c.push_back("вермут");
	c.push_back("вино");

	copy(c.begin(), c.end(), ostream_iterator<string>(cout, " "));
	cout<<endl;

	sort(c.begin(), c.end());

	copy(c.begin(), c.end(), ostream_iterator<string>(cout, " "));
	cout<<endl;

	string sss = "бан";

	vector<string>::iterator i1 = lower_bound(c.begin(), c.end(), sss, my_check);
	if(i1 == c.end()) {
		cout<<"i1 == end()"<<endl;
	}
	else {
		cout<<"i1 == "<<*i1<<endl;
	}
	vector<string>::iterator i2 = upper_bound(c.begin(), c.end(), sss, my_check);
	if(i2 == c.end()) {
		cout<<"i2 == end()"<<endl;
	}
	else {
		cout<<"i2 == "<<*i2<<endl;
	}

	copy(i2, i1, ostream_iterator<string>(cout, " "));
	cout<<endl;

	return 0;
}

