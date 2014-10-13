#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char **argv) {
	vector<int> a(10);

	{
		vector<float> ff(10);

		ff[5] = 2.0;
	}

	for (int i = 0; i < 10; i++) {
		a[i] = i * i;
	}

	for (int i = 0; i < 10; i++) {
		std::cout << a[i] << std::endl;
	}

	a.resize(11);
	a.at(10) = 0;
	cout<<a.at(10)<<endl;

	a.push_back(100);
	cout<<a.at(11)<<endl;

	a.insert(a.begin(), 333);
	cout<<endl;
	for (int i = 0; i < a.size(); i++) {
		std::cout << a[i] << std::endl;
	}
	cout<<endl;
	for (vector<int>::iterator i=a.begin(); i!=a.end(); i++) {
		std::cout << *i << std::endl;
	}

	cout<<endl;
	for (vector<int>::reverse_iterator i=a.rbegin(); i!=a.rend(); i++) {
		std::cout << *i << std::endl;
	}
}
