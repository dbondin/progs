#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>
#include <cstdlib>

using namespace std;

struct msg {
	string user;
	string text;
};

int main(int argc, char **argv) {

	vector<int> a;

	a.push_back(1);
	a.push_back(1);
	a.push_back(2);
	a.push_back(3);
	a.push_back(4);
	a.push_back(4);
	a.push_back(4);
	a.push_back(5);
	a.push_back(6);
	a.push_back(6);
	a.push_back(2);
	a.push_back(2);
	a.push_back(1);

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	vector<int>::iterator new_end = unique(a.begin(), a.end());
	a.erase(new_end, a.end());

	copy(a.begin(), a.end(), ostream_iterator<int>(cout, " "));
	cout<<endl;

	vector<msg> b;

	b.push_back({"dima", "hello"});
	b.push_back({"petya", "hello"});
	b.push_back({"dima", "sam hello"});
	b.push_back({"petya", ": ("});
	b.push_back({"dima", "//"});
	b.push_back({"dima", "//"});
	b.push_back({"dima", "//"});
	b.push_back({"petya", ": ("});
	b.push_back({"petya", ": ("});
	b.push_back({"petya", ": ("});
	b.push_back({"dima", "-----"});

	vector<msg>::iterator x = unique(b.begin(), b.end(), [](msg _x, msg _y)
			{
				return _x.user == _y.user;
			});
	b.erase(x, b.end());

	transform(b.begin(), b.end(), ostream_iterator<string>(cout, " "), [](const msg & m)
			{
				return m.user;
			});
	cout<<endl;

	return 0;
}

