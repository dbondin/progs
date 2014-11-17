#include <set>
#include <deque>
#include <algorithm>
#include <iterator>
#include <functional>
#include <iostream>

#include "../utils/print_container.hxx"

using namespace std;
using namespace std::placeholders;

int main() {
	set<int, greater<int>> coll1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	deque<int> coll2;

	print_container(coll1);

	transform(coll1.begin(), coll1.end(), back_inserter(coll2),
			bind(multiplies<int>(), std::placeholders::_1, 10));

	print_container(coll2);

	replace_if(coll2.begin(), coll2.end(), bind(equal_to<int>(), _1, 70), 42);

	print_container(coll2);

	//remove_if(coll2.begin(), coll2.end(),
	//					bind(logical_and<bool>(),
	//							bind(greater_equal<int>(), _1, 50),
	//							bind(less_equal<int>(), _1, 80)));

	coll2.erase(
			remove_if(coll2.begin(), coll2.end(),
					bind(logical_and<bool>(),
							bind(greater_equal<int>(), _1, 50),
							bind(less_equal<int>(), _1, 80))), coll2.end());

	print_container(coll2);
}
