#include <algorithm>
#include <iostream>
#include <iterator>
#include <list>

#include "../utils/print_container.hxx"

using namespace std;

bool isPrime(int number) {
// ignore negative sign
	number = abs(number);
// 0 and 1 are no prime numbers
	if (number == 0 || number == 1) {
		return false;
	}
	// find divisor that divides without a remainder
	int divisor;
	for (divisor = number / 2; number % divisor != 0; --divisor) {
		;
	}
	// if no divisor greater than 1 is found, it is a prime number
	return divisor == 1;
}

int main() {
	list<int> coll;
// insert elements from 24 to 30
	for (int i = 24; i <= 300; ++i) {
		coll.push_back(i);
	}

	auto pos = coll.begin();

	while(true) {
		pos = find_if(pos, coll.end(), isPrime);
		if(pos == coll.end()) {
			break;
		}
		cout<<*pos<<" ";
		pos++;
	}
}
