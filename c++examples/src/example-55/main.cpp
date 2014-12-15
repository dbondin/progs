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

	iota(a.begin(), a.begin() + 5, 1);
	iota(a.begin() + 5, a.end(), 1);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	vector<int>::iterator new_end = remove(a.begin(), a.end(), 5);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	a.erase(new_end, a.end());

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	new_end = remove_if(a.begin(), a.end(), [](int _x)
			{
				return (_x % 3) == 0;
			});

	a.erase(new_end, a.end());

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	vector<int> b;
	remove_copy(a.begin(), a.end(), back_inserter(b), 2);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;
	copy(b.begin(), b.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;




	return 0;
}

