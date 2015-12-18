#include <vector>
#include <iostream>
#include <iterator>
#include <algorithm>
#include <functional>

using namespace std;

//int int_comp_fn_counter = 0;
//
//bool int_comp_fn(const int & i1, const int & i2) {
//	++int_comp_fn_counter;
//	return i1 > i2;
//}

class IntCriterion {
public:
	IntCriterion() { count = new int(0); };
	virtual ~IntCriterion() { /*FIXME!!! SharedPtr */ };
	bool operator() (const int & i1, const int & i2) {
		(*count) = (*count) + 1;
		cout<<"--- "<<(void *)this<<" "<<(*count)<<endl;
		return i1 > i2;
	}
	int getCount() const {
		return *count;
	}
private:
	int * count;
};

class X {
public:
	void operator()(const int & v) {
		++count;
		sum += v;
	}
	double avg() {
		return ((double) sum) / count;
	}
private:
	int sum, count;
};

int main(int argc, char **argv) {

	vector<int> v1 = {4, 2, 6, 3, 8, 6, 9, 1, 7, 1};
	vector<int> v2 = {4, 2, 6, 3, 8, 6, 9, 1, 7, 1, 5, 7, 9};
	IntCriterion ic1;
	IntCriterion ic2;

	::sort(v1.begin(), v1.end(), ic1);
	::copy(v1.begin(), v1.end(), ::ostream_iterator<int>(::cout, " * "));
	::cout<<endl;

	::sort(v2.begin(), v2.end(), ic2);
	::copy(v2.begin(), v2.end(), ::ostream_iterator<int>(::cout, " * "));
	::cout<<endl;

	::cout<<ic1.getCount()<<endl;
	::cout<<ic2.getCount()<<endl;

	X x = ::for_each(v2.begin(), v2.end(), X());
	::cout<<"avg="<<x.avg()<<endl;

	::cout<<negate<int>()(100)<<endl;
	::cout<<::multiplies<int>()(100, 5)<<endl;

	auto a = std::bind(std::plus<int>(),
			std::placeholders::_1,
			13);
	cout<<a(14)<<endl;

	auto p3 = std::bind(std::multiplies<int>(),
			std::placeholders::_1,
			std::bind(std::multiplies<int>(),
					std::placeholders::_1,
					std::placeholders::_1));
	cout<<p3(2)<<endl;

	auto x3plus13 = std::bind(a,
			std::bind(p3,
					std::placeholders::_1));
	cout<<x3plus13(3)<<endl;

	vector<int> v3 = {3, 5, 1, 2, 5, 8, 3, 6, 9, 3, 6, 8, 3, 6};

	::sort(v3.begin(), v3.end(), [](const int &x, const int &y) { return x>y; } );

	::copy(v3.begin(), v3.end(), ostream_iterator<int>(cout, " "));
	::cout<<endl;

	return 0;
}
