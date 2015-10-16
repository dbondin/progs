#include <iostream>
#include <unistd.h>
//#include <auto_ptr.h>
#include <memory>

using namespace std;

class MyClass {
public:
	MyClass(const string & _value) : value(_value) {
		cout<<"MyClass::MyClass("<<value<<") called"<<endl;
	}
	virtual ~MyClass() {
		cout<<"MyClass::~MyClass("<<value<<") called"<<endl;
	}
	const string & get_value() {
		return value;
	}
private:
	string value;
};

class MyClassAutoPtr {
public:
	MyClassAutoPtr(MyClass * _ptr) : ptr(_ptr) {

	}
	~MyClassAutoPtr() {
		if(ptr != NULL) {
			delete ptr;
		}
	}
	MyClass * operator -> () {
		return ptr;
	}
private:
	MyClass * ptr;
};

void doit() {
	MyClass c("first");
	MyClass * pc = new MyClass("second");
	//auto_ptr<MyClass> apc(new MyClass("third"));
	MyClassAutoPtr myapc(new MyClass("fourth"));
	shared_ptr<MyClass> shpc(new MyClass("fifth"));
	unique_ptr<MyClass> upc(new MyClass("sixth"));

	cout<<">> "<<c.get_value()<<endl;
	cout<<">> "<<pc->get_value()<<endl;
	//cout<<">> "<<apc->get_value()<<endl;
	cout<<">> "<<myapc->get_value()<<endl;
	cout<<">> "<<shpc->get_value()<<endl;
	cout<<">> "<<upc->get_value()<<endl;

	// ....
	//delete pc;
	return;
}

int main(int argc, char **argv) {
	doit();
	cout<<"Go to sleep"<<endl;
	while(true) {
		sleep(1);
	}
	return 0;
}
