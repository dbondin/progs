#include<vector>
#include<list>
#include<iostream>
#include<algorithm>
#include<iterator>

using namespace std;


int main(int argc, char **argv) {

	vector<string> v1 = {"hello", "world", "123"};
	list<string> l1 = {"hello", "world", "123", "456"};

	cout<<equal(v1.cbegin(), v1.cend(), l1.cbegin())<<endl;
	// cout<<equal(l1.cbegin(), l1.cend(), v1.cbegin())<<endl;

	vector<int> v2 = {1, 2, 3, 4, 5, 6};
	list<int> l2 = {0, 3, 5, 6, 4, 2};

	cout<<is_permutation(v2.cbegin(), v2.cend(), l2.cbegin())<<endl;

	return 0;
}
