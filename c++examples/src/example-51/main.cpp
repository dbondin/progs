#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>

using namespace std;

int main(int argc, char **argv) {

	vector<int> a;
	vector<int> b;

	for(int i=0; i<10; i++) {
		a.push_back(i);
		b.push_back(-i);
	}

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;
	copy(b.begin(), b.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	vector<int>::iterator f = find(a.begin(), a.end(), 3);
	if(f != a.end()) {
		swap_ranges(f, f+3, b.begin());
	}

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;
	copy(b.begin(), b.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	return 0;
}

