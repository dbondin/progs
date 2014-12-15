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

int main(int argc, char **argv) {

	vector<int> c;

	srand(time(NULL));

	for(int i=0; i<10; i++) {
		c.push_back(rand() % 10);
	}

	copy(c.begin(), c.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	sort(c.begin(), c.end());

	copy(c.begin(), c.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	cout<<binary_search(c.begin(), c.end(), 5)<<endl;

	return 0;
}

