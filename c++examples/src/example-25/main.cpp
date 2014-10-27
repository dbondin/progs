#include<map>
#include<string>
#include<iostream>

using namespace std;

template<class T>
void print_container(T & c) {
	for (typename T::iterator i = c.begin(); i != c.end(); i++) {
		if (i != c.begin()) {
			cout << ", ";
		}
		cout << *i;
	}
	cout << endl;
}

int main(int argc, char **argv) {
	map<string, string> dic;

	pair<string, string> p1("hello", "привет");
	dic.insert(p1);
	pair<string, string> p2("computer", "компьютер");
	dic.insert(p2);
	pair<string, string> p3("world", "мир");
	dic.insert(p3);
	pair<string, string> p4("helicopter", "вертолет");
	dic.insert(p4);
	pair<string, string> p5("car", "автомобиль (легковой)");
	dic.insert(p5);

	string s;
	while (true) {
		cout << "Enter word: ";
		cin >> s;

		map<string, string>::const_iterator i = dic.find(s);
		if (i == dic.end()) {
			cout << "Not found" << endl;
		} else {
			cout << (*i).first << ": " << (*i).second << endl;
		}
	}

	return 0;
}
