#include<vector>
#include<iostream>
#include<algorithm>
#include<iterator>

using namespace std;


int main(int argc, char **argv) {
	vector<int> v1 = {1, 4, 6, 2, 6, 89, 2, 6, 5, 4, 0};

	::for_each(v1.cbegin(), v1.cend(), [](const int & i) {::cout<<i<<"^2="<<i*i<<endl;});

	::for_each(v1.begin(), v1.end(), [](int & i) { i++; });
	::copy(v1.cbegin(), v1.cend(), ostream_iterator<int>(cout, ", "));
	::cout<<endl;

	::cout<<"count(2)="<<::count(v1.cbegin(), v1.cend(), 2)<<endl;
	::cout<<"count(3)="<<::count(v1.cbegin(), v1.cend(), 3)<<endl;
	::cout<<"count(odd)="<<::count_if(v1.cbegin(), v1.cend(), [](const int & i){return (i%2 != 0);})<<endl;

	::cout<<"min()="<<*(::min_element(v1.begin(), v1.end()))<<endl;

	auto x = ::find(v1.cbegin(), v1.cend(), 91);
	if(x == v1.cend()) {
		::cout<<"not found"<<endl;
	}
	else {
		::cout<<*x<<endl;
	}

	vector<string> v2 = {"hello", "world", "how", "are", "you", "lalal"};
	vector<string>::const_iterator beg = v2.cbegin();
	while(true) {
		beg = find_if_not(beg, v2.cend(), [](const string & s){ return s[0] == 'h';});
		// beg = find_if(beg, v2.cend(), [](const string & s){ return s.length() == 5;});
		if(beg == v2.cend()) {
			break;
		}
		cout<<">> "<<*beg<<endl;
		beg++;
	}

	vector<int> v3 = {1, 1, 2, 3, 5, 8, 13, 21, 34};
	vector<int> v4 = {2, 3, 5};

	auto v3i = search(v3.cbegin(), v3.cend(), v4.cbegin(), v4.cend());
	if(v3i == v3.cend()) {
		cout<<"not found !!!"<<endl;
	}

	string s1 = "aaaaaasssssse";
	string s2 = "eo";
	cout<<*(find_first_of(s1.begin(), s1.end(), s2.begin(), s2.end()))<<endl;

	return 0;
}
