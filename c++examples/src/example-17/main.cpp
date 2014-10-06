#include<iostream>
#include<string>

#include"Stack.hxx"

using namespace std;

int main(int argc, char **argv) {
	Stack<> si(10);
	si.push(10);
	cout<<si.pop()<<endl;

	Stack<string> ss(5);
	ss.push("hello");
	ss.push("world");
	cout<<ss.count()<<endl;
	cout<<ss.pop()<<endl;
	cout<<ss.count()<<endl;

	return 0;
}
