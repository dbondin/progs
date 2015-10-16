#include <iostream>

using namespace std;

class Animal {
public:
	virtual string scream() = 0;
};


class A {
public:
	virtual void xxx() {
		cout<<"AAA"<<endl;
	}
};

class B : public A {
public:
	void xxx() {
		cout<<"BBB"<<endl;
	}
};

class C : public A {
public:
	void xxx() {
		cout<<"CCC"<<endl;
	}
};

class D : public C {

};

void func(A & a) {
	//.....
	a.xxx();
	//.....
}

void put_foot_on_tail(Animal & a) {
	cout<<a.scream()<<endl;
}

class Cat : public Animal {
public:
	virtual string scream() {
		return "МЯЯЯЯЯУУУ";
	}
};

class Dog : public Animal {
public:
	virtual string scream() {
		return "УУУУУУУУУ";
	}
};

int main(int argc, char **argv) {

	A a;
	B b;
	C c;
	D d;

	func(a);
	func(b);
	func(c);
	func(d);

	Cat cat;
	put_foot_on_tail(cat);
	Dog dog;
	put_foot_on_tail(dog);

	return 0;
}
