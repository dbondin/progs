#include<vector>
#include<list>
#include<iostream>
#include<iterator>

using namespace std;

int main(int argc, char **argv) {
	vector<int> v = {1, 2, 3, 5, 7, 11};
	vector<int>::iterator i1 = v.begin();
	vector<int>::iterator i2 = next(i1, 3);

	list<int> l = {1, 2, 3, 5, 7, 11};
	list<int>::reverse_iterator j1 = l.rbegin();
	list<int>::reverse_iterator j2 = next(j1, 3);

	cout<<*i1<<" "<<*i2<<endl;

	cout<<distance(i2, i1)<<endl;
	cout<<distance(j1, j2)<<endl;

	return 0;
}
