#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>

#include <cstdlib>
#include <ctime>

#include <cmath>

using namespace std;

bool is_prime(int x) {
	for(int i=2; i<sqrt(x); i++) {
		if(x%i == 0) {
			return false;
		}
	}
	return true;
}

int main(int argc, char **argv) {
	vector<int> v;

	srand(time(NULL));

	for(int i=0; i<10; i++) {
		v.push_back(rand());
	}

	copy(v.begin(), v.end(), ostream_iterator<int>(cout, ", "));
	cout<<endl;

	vector<int>::iterator pos = v.begin();
	while(true) {
		pos = find_if(pos, v.end(), [](int elem) {
			return elem%2 == 0;
		});
		if(pos == v.end()) {
			break;
		}
		cout << "Even: " << *pos << endl;
		pos++;
	}

	cout<<"13: "<<is_prime(13) << endl;
	cout<<"14: "<<is_prime(14) << endl;
	cout<<"15: "<<is_prime(15) << endl;
	cout<<"16: "<<is_prime(16) << endl;
	cout<<"17: "<<is_prime(17) << endl;

	cout<<"Find primes:"<<endl;
	pos = v.begin();
	while (true) {
		pos = find_if(pos, v.end(), is_prime);
		if (pos == v.end()) {
			break;
		}
		cout << "Prime: " << *pos << endl;
		pos++;
	}

	return 0;
}
