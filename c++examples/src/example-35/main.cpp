#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <set>
#include <iterator>

#include "../utils/print_container.hxx"

using namespace std;

template <int arg = 10>
int fun (int value)
{
	return arg * value;
}

class Fun {
public:
	Fun(int arg = 10) {
		this->arg = arg;
	}
	// arg * value + previous
	int operator ()(int value) {
		int prev = this->prev;
		int result = arg * value + prev;
		this->prev = result;
		return result;
	}
private:
	int arg;
	int prev = 0;
};

int main() {
	std::set<int> coll1;
	std::vector<int> coll2;
	// insert elements from 1 to 9 into coll1
	for (int i=1; i<=9; ++i) {
		coll1.insert(i);
	}
	print_container(coll1);
	// transform each element from coll1 to coll2
	// - square transformed values
	int arg = 13;

	auto l = [=] (int value) {return value * arg;};

	std::transform(coll1.begin(),coll1.end(),
			std::back_inserter(coll2),
			l);

	print_container(coll2);
}
