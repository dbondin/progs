#include<iostream>
#include<string>
#include<sstream>
#include<deque>

using namespace std;

/*
 * 			cout<<"-- ";
			for(deque<double>::iterator i = st.begin(); i != st.end(); i++) {
				cout<<*i<<", ";
			}
			cout<<endl;
 *
 */

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

	cout<<"> "<<endl;

	string line;

	getline(cin, line);

	if(cin.bad()) {
		return 0;
	}

	istringstream ss(line);

	deque<double> st(100);

	while(!ss.eof()) {
		string str;
		ss>>str;
		if(str == "+") {
			double x1 = st.back(); st.pop_back();
			double x2 = st.back(); st.pop_back();
			st.push_back(x2 + x1);
		}
		else if(str == "-") {
			double x1 = st.back(); st.pop_back();
			double x2 = st.back(); st.pop_back();
			st.push_back(x2 - x1);
		}
		else if(str == "*") {
			double x1 = st.back(); st.pop_back();
			double x2 = st.back(); st.pop_back();
			st.push_back(x2 * x1);
		}
		else if(str == "/") {
			double x1 = st.back(); st.pop_back();
			double x2 = st.back(); st.pop_back();
			st.push_back(x2 / x1);
		}
		else if(str == "=") {
			cout<<"-- ";
			print_container(st);
		}
		else {
			istringstream tmps(str);
			double d;
			tmps>>d;
			st.push_back(d);
		}
	}

	cout<<st.back()<<endl;

	return 0;
}
