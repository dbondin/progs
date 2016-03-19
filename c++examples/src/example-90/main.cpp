#include<vector>
#include<list>
#include<iostream>
#include<algorithm>
#include<iterator>
#include<cmath>

using namespace std;


int main(int argc, char **argv) {

	vector<int> v1 = {1, 2, 3};
	vector<int> v2 = {4, 5, 6, 7, 8};

	::copy_backward(v1.begin(), v1.end(), v2.end()--);

	::copy(v2.begin(), v2.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	vector<double> v3;

	::transform(v1.begin(), v1.end(), ::back_inserter(v3), [] (const int & i) {return sqrt((double)i);});

	::copy(v3.begin(), v3.end(), ostream_iterator<double>(cout, " "));
	cout<<endl;

	vector<int> v4 = {4, 5, 6};
	vector<double> v5;

	::transform(v1.begin(), v1.end(), v4.begin(), ::back_inserter(v5),
			[] (const int & a, const int & b) {
				return sqrt((double)(a*a+b*b));
			});

	cout<<"v5: ";
	::copy(v5.begin(), v5.end(), ostream_iterator<double>(cout, "; "));
	cout<<endl;

	vector<char> v6 = {'a', 'b', 'c', 'd'};
	vector<char> v7 = {'A', 'B', 'C', 'D'};

	::swap_ranges(v6.begin() + 1, v6.begin() + 3, v7.begin() + 1);
	cout<<"v6: ";
	::copy(v6.begin(), v6.end(), ostream_iterator<char>(cout, "; "));
	cout<<endl;
	cout<<"v7: ";
	::copy(v7.begin(), v7.end(), ostream_iterator<char>(cout, "; "));
	cout<<endl;

	vector<int> v8;
	::generate_n(::back_inserter(v8), 3,
			[]() {
		int x=0;
		// cout<<"enter next number: ";
		// cin>>x;
		return x;
	});
	cout<<"v8: ";
	::copy(v8.begin(), v8.end(), ostream_iterator<int>(cout, "; "));
	cout<<endl;

	vector<int> v9 = {2, -4, 5, -6, -7, 7};

	::replace_if(v9.begin(), v9.end(), [](const int & x) {return x<0;}, 0);
	cout<<"v9: ";
	::copy(v9.begin(), v9.end(), ostream_iterator<int>(cout, "; "));
	cout<<endl;

	return 0;
}
