#include <vector>
#include <array>
#include <iostream>
#include <exception>

using namespace std;

template <class T>
void myswap(vector<T> a, vector<T> b) {

}

int main(int argc, char **argv) {

	vector<string> v;

	cout<<v.size()<<endl;
	cout<<v.capacity()<<endl;

	vector<string> v2(5, ":)");
	cout<<v2.size()<<endl;
	cout<<v2.capacity()<<endl;
	v2.push_back("");
	cout<<v2.size()<<endl;
	cout<<v2.capacity()<<endl;

	vector<string> tmp(v2);
	cout<<"before: v2.data = "<<(void *) v2.data()<<"; tmp.data = "<<(void *)tmp.data()<<endl;
	v2.swap(tmp);
	cout<<"before: v2.data = "<<(void *) v2.data()<<"; tmp.data = "<<(void *)tmp.data()<<endl;
	//swap(v2, tmp);
	cout<<v2.size()<<endl;
	cout<<v2.capacity()<<endl;

	array<int, 5> ax = {10, 20, 30, 40, 50};
	vector<double> vx(ax.begin(), ax.end());
	for(int value : vx) {
		cout<<"- " <<value<<endl;
	}
	//vx.at(5) = 3;

	return 0;
}
