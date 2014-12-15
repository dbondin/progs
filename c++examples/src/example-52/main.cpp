#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>
#include <cstdlib>

using namespace std;

class seq {
public:
	seq(int initial) {
		this->value = initial;
	}
	int operator()(){
		return value ++;
	}
private:
	int value;
};

int main(int argc, char **argv) {

	vector<int> a(10);

	fill(a.begin(), a.end(), 123);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	fill_n(a.begin(), 5, 999);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	vector<int> b(10);

	generate(b.begin(), b.end(), rand); // int f()

	copy(b.begin(), b.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	vector<int> c(10);

	iota(c.begin(), c.end(), 100);

	copy(c.begin(), c.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;


	vector<int> d(10);

	generate(d.begin(), d.end(), seq(100));

	copy(d.begin(), d.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;



	return 0;
}

