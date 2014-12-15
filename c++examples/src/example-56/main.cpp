#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>
#include <cstdlib>
#include <unistd.h>

using namespace std;

int main(int argc, char **argv) {

	vector<int> a;

	a.push_back(1);
	a.push_back(1);
	a.push_back(2);
	a.push_back(3);
	a.push_back(4);
	a.push_back(4);
	a.push_back(4);
	a.push_back(5);
	a.push_back(6);
	a.push_back(6);
	a.push_back(2);
	a.push_back(2);
	a.push_back(1);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	reverse(a.begin(), a.end());

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	vector<char> b;
	b.push_back(' ');
	b.push_back(' ');
	b.push_back(' ');
	b.push_back(' ');
	b.push_back('<');
	b.push_back('*');
	b.push_back('>');
	b.push_back(' ');
	b.push_back(' ');
	b.push_back(' ');

	for(int i=0; i<100; i++) {
		rotate(b.begin(), b.end() - 1, b.end());
		cout<<"  ";
		copy(b.begin(), b.end(), ostream_iterator<char>(cout, " "));
		cout<<"\r";
		cout.flush();
		sleep(1);
	}
	cout<<endl;

	return 0;
}

