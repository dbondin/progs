#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>

#include <cstdlib>
#include <ctime>

using namespace std;

int main(int argc, char **argv) {

	srand(time(NULL));

	vector<int> data;

	for(int i=0; i<10000; i++) {
		data.push_back(rand());
	}
	//data.push_back(1);
	//data.push_back(2);

	vector<int> s;

	s.push_back(1);
	s.push_back(2);

	if(search(data.begin(), data.end(), s.begin(), s.end()) != data.end()) {
		cout << "found !!!" << endl;
	}
	else  {
		cout << "not found !!!" << endl;
	}

	return 0;
}
