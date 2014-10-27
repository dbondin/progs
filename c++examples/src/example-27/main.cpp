#include<unordered_map>
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
	//unordered_map<string, string> dic;
	map<string, string> dic;

	dic["hello"] = "привет";
	dic["computer"] = "компьютер";
	dic["world"] = "мир";
	dic["helicopter"] = "вертолет";
	dic["car"] = "автомобиль (легковой)";
	dic["computer"] = "шайтан-коробка";

	string s;
	while (true) {
		cout << "Enter word: ";
		cin >> s;
		if(dic.find(s) != dic.end()) {
			cout<<dic[s]<<endl;
		}
		else {
			cout<<"not found"<<endl;
		}
	}

	return 0;
}
