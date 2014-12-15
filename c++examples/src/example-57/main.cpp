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
	a.push_back(2);
	a.push_back(3);
	a.push_back(4);

	bool has_next = true;
	while(true) {
		copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
		cout<<endl;

		if(!has_next) {
			break;
		}

		has_next = next_permutation(a.begin(), a.end());

	}
	cout<<endl;

	random_shuffle(a.begin(), a.end());
	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	return 0;
}

