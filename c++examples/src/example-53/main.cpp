#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>
#include <cstdlib>

using namespace std;

int main(int argc, char **argv) {

	vector<int> a(10);

	iota(a.begin(), a.end(), 1);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	replace(a.begin(), a.end(), 5, 50);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	replace_if(a.begin(), a.end(), [](int _x)
			{
				return (_x % 2) == 0;
			}, 999);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	return 0;
}

