#include <vector>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>
#include <cstdlib>
#include <unistd.h>

using namespace std;

class Cat {
public:
	Cat(string _name, int _age) : name(_name), age(_age) {
	};
	friend ostream & operator<< (ostream & os, const Cat & cat) {
		os<<'['<<cat.name<<';'<<cat.age<<']';
		return os;
	}
	int get_age() const {
		return this->age;
	}
private:
	string name;
	int age;
};

int main(int argc, char **argv) {

	vector<Cat> c;

	c.push_back(Cat("Васька", 3));
	c.push_back(Cat("Мурка", 2));
	c.push_back(Cat("Пушок", 1));
	c.push_back(Cat("Барсик", 3));
	c.push_back(Cat("Матроскин", 4));
	c.push_back(Cat("Матроскина", 4));
	c.push_back(Cat("Рыжик", 5));
	c.push_back(Cat("Мурзик", 3));

	copy(c.begin(), c.end(), ostream_iterator<Cat>(cout, " "));
	cout<<endl;

	partition(c.begin(), c.end(), [](const Cat & a){return (a.get_age() < 4);});

	copy(c.begin(), c.end(), ostream_iterator<Cat>(cout, " "));
	cout<<endl;

	sort(c.begin(), c.end(), [] (const Cat & a, const Cat & b) {return a.get_age() < b.get_age();});

	copy(c.begin(), c.end(), ostream_iterator<Cat>(cout, " "));
	cout<<endl;

	cout<<endl;

	c.clear();

	c.push_back(Cat("Васька", 3));
	c.push_back(Cat("Мурка", 2));
	c.push_back(Cat("Пушок", 1));
	c.push_back(Cat("Барсик", 3));
	c.push_back(Cat("Матроскин", 4));
	c.push_back(Cat("Матроскина", 4));
	c.push_back(Cat("Рыжик", 5));
	c.push_back(Cat("Мурзик", 3));

	copy(c.begin(), c.end(), ostream_iterator<Cat>(cout, " "));
	cout<<endl;

	stable_partition(c.begin(), c.end(), [](const Cat & a){return (a.get_age() < 4);});

	copy(c.begin(), c.end(), ostream_iterator<Cat>(cout, " "));
	cout<<endl;

	stable_sort(c.begin(), c.end(), [] (const Cat & a, const Cat & b) {return a.get_age() < b.get_age();});

	copy(c.begin(), c.end(), ostream_iterator<Cat>(cout, " "));
	cout<<endl;

	return 0;
}

