#include <iostream>
#include <string>
#include <cstring>
#include <vector>

using namespace std;

void old_fn(char * str) {
	///
}

class human {

public:
	human(const string & name, const string & last_name, int age) : _name(name), _last_name(last_name), _age(age) {
		//
	}
	string & name() {
		return _name;
	}
	string & last_name() {
		return _last_name;
	}
	int age() {
		return _age;
	}

	friend ostream & operator << (ostream & os, const human & value) {
		os<<value._name<<" "<<value._last_name<<" "<<value._age;
		return os;
	}

private:
	string _name;
	string _last_name;
	int _age;
};

template<class T>
void doit(T t) {
	for(typename T::iterator iter = t.begin(); iter != t.end(); iter++) {
		cout<<":: "<<*iter<<endl;
	}
}

int main(int argc, char **argv) {

	string s1 = "abc";
	string s2("abc");

	cout<<s1<<endl;
	cout<<s2<<endl;

	old_fn(const_cast<char*>(s1.c_str()));

	string s3;
	s3.push_back('a');
	s3.push_back('b');
	s3.push_back('c');
	s3.push_back(0);
	s3.push_back('1');
	s3.push_back('2');
	s3.push_back('3');

	cout<<s3.length()<<endl;

	const char * c_s3 = s3.c_str();

	cout<<strlen(c_s3)<<endl;

	string s4 = "abcde";
	string s5 = "abcde";

	cout<<s4.compare(s5)<<endl;

	s4.reserve(10);

	cout<<s4.length()<<" "<<s4.capacity()<<endl;

	cout<<s4[4]<<endl;
	cout<<s4.at(4)<<endl;

	human me("Дмитрий", "Бондин", 36);

	cout<<me.name()<<" "<<me.last_name()<<" "<<me.age()<<endl;
	cout<<me<<endl;

	doit<string>(s4);

	vector<human> vh;
	vh.push_back(human("Дмитрий", "Бондин", 36));
	vh.push_back(human("John", "Doe", 0));

	doit<vector<human>>(vh);

	return 0;
}
