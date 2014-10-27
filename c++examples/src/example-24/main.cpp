#include<set>
#include<iostream>
#include<string>

using namespace std;

template<class T>
void print_container(T & c) {
	for (typename T::iterator i = c.begin(); i != c.end(); i++) {
		if(i != c.begin()) {
			cout << ", ";
		}
		cout << *i;
	}
	cout << endl;
}

int main(int argc, char **argv) {
	multiset<string> s;

	s.insert("Dima");
	s.insert("Petya");
	s.insert("Sasha");
	s.insert("Vasya");
	s.insert("Vasya");
	s.insert("Zhenya");
	s.insert("Zhenya");

	print_container(s);

	set<string>::const_iterator i = s.find("Petya");
	if(i == s.end()) {
		cout<<"Not found"<<endl;
	}
	else {
		for(;i!=s.end(); ++i) {
			cout<<"+ "<<*i<<endl;
		}
	}

	return 0;
}
