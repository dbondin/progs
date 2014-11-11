#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
using namespace std;

struct student {
	string first_name;
	string last_name;
};

void print_student(student & s) {
	cout << s.last_name << ' ' << s.first_name << endl;
}

template <typename T>
void print(T elem) {
	cout << elem << ' ';
}

int ccc(int x, int y) {
	return x > y;
}

int student_comp(const student & x, const student & y) {
	if(x.last_name < y.last_name) {
		return -1;
	}
	else if(x.last_name > y.last_name) {
		return 1;
	}
	else {
		return x.first_name < y.first_name;
	}
}

int main() {
	vector<int> coll;
	for (int i = 1; i <= 9; ++i) {
		coll.push_back(i);
	}
	for_each(coll.begin(), coll.end(), print<int>);
	cout << endl;

	vector<int> coll2 = {2, 4, 3, 6, 7, 8, 9, 1, 5};
	sort(coll2.begin(), coll2.end(), ccc);
	for_each(coll2.begin(), coll2.end(), print<int>);
	cout << endl;

	vector<student> vs = { {"Дмитрий", "Бондин"},
			{"Александр", "Бондин"},
			{"Александр", "Акунин"}
	};
	sort(vs.begin(), vs.end(), student_comp);
	for_each(vs.begin(), vs.end(), print_student);
	cout << endl;
}
