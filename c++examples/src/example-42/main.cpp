// util/sharedptr1.cpp
#include <iostream>
#include <string>
#include <vector>
#include <memory>
using namespace std;


class A {
public:
	A(int data) {
		cout<<"A() called"<<endl;
		this->data = data;
	}
	~A() {
		cout<<"~A() called"<<endl;
	}
private:
	int data;
};

shared_ptr<A> X;

void f(vector<shared_ptr<A>> & v) {
	cout<<"f() called"<<endl;
	shared_ptr<A> pA(new A(10));
	//v.push_back(pA);
	X=pA;
	cout<<"f() end "<<pA.use_count()<<endl;
}

int main() {
	cout<<"main() called"<<endl;
	vector<shared_ptr<A>> v;
	f(v);
	cout<<"main() end"<<endl;
}
