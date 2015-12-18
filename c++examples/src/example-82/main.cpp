#include <set>
#include <iostream>

using namespace std;

template <class T>
void dump(T & c) {
	for(typename T::iterator i=c.begin(); i!= c.end(); i++) {
		cout<<*i<<" ";
	}
	cout<<endl;
}

class Cat {
public:

	Cat(const string& name, int age, char gender) {
		setName(name);
		setAge(age);
		setGender(gender);
	}

	int getAge() const {
		return age;
	}

	void setAge(int age) {
		this->age = age;
	}

	char getGender() const {
		return gender;
	}

	void setGender(char gender) {
		if(gender != 'm' && gender != 'f') {
			gender = 'm';
		}
		this->gender = gender;
	}

	const string& getName() const {
		return name;
	}

	void setName(const string& name) {
		this->name = name;
	}

	int
	operator < (const Cat& c1) const {
		return getAge() < c1.getAge();
	}

	friend
	ostream & operator<<(ostream & os, const Cat & c) {
		return os<<c.name<<" "<<c.age<<" "<<c.gender;
	}

private:
	string name;
	int age;
	char gender;
};

//class SortCatFunctor {
//	bool operator()(const Cat & c1, const Cat & c2) const {
//		return c1.getAge() < c2.getAge();
//	}
//};

int main(int argc, char **argv) {
	set<int> s1;
	s1.insert(11);
	s1.insert(1);
	s1.insert(5);
	s1.insert(7);
	s1.insert(2);
	s1.insert(3);
	dump(s1);

	set<Cat> s2;
	s2.insert(Cat("Васька", 3, 'm'));
	s2.insert(Cat("Пушок", 2, '-'));
	s2.insert(Cat("Мурка", 1, 'f'));
	s2.insert(Cat("Барсик", 10, 'm'));

	dump(s2);

	Cat c("Васька", 3, 'm');

	set<Cat>::iterator i = s2.find(c);
	if(i == s2.end()) {
		cout<<"Не найден"<<endl;
	}
	else {
		cout<<*i<<endl;
	}
}
