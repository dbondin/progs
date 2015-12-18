#include <list>
#include <iostream>
#include <cstdlib>
#include <ctime>
#include <unistd.h>

using namespace std;

void initlist(list<int> & l, int count) {
	for(int i=0; i<count; i++) {
		l.push_back(rand() % 3);
	}
}

int my_sort_fn(const int & x, const int & y) {
//	if(x == 0 && y != 0) {
//		return 1;
//	}
	return x > y;
}

int main(int argc, char **argv) {
	list<int> l1;
	srand(time(NULL) + getpid());
	initlist(l1, 10);
	cout<<"l1:";
	for(list<int>::iterator i=l1.begin(); i!=l1.end(); i++) {
		cout<<*i<<" ";
	}
	cout<<endl;
	l1.unique();
	cout<<"l1:";
	for(list<int>::iterator i=l1.begin(); i!=l1.end(); i++) {
		cout<<*i<<" ";
	}
	cout<<endl;
	list<int> l2;
	initlist(l2, 10);
	cout<<"l2:";
	for(list<int>::iterator i=l2.begin(); i!=l2.end(); i++) {
		cout<<*i<<" ";
	}
	cout<<endl;
	list<int>::iterator l1b = l1.begin() ++ ++ ++ ++ ++;
	list<int>::iterator l2b = l2.begin() ++ ++;
	list<int>::iterator l2e = l2.begin() ++ ++ ++ ++;
	l1.splice(l1b, l2, l2b, l2e);
	cout<<"l1:";
	for(list<int>::iterator i=l1.begin(); i!=l1.end(); i++) {
		cout<<*i<<" ";
	}
	cout<<endl;
	cout<<"l2:";
	for(list<int>::iterator i=l2.begin(); i!=l2.end(); i++) {
		cout<<*i<<" ";
	}
	cout<<endl;
	list<int> l3;
	initlist(l3, 20);
	cout<<"l3:";
	for(list<int>::iterator i=l3.begin(); i!=l3.end(); i++) {
		cout<<*i<<" ";
	}
	cout<<endl;
	//l3.sort();
	l3.sort(my_sort_fn);
	cout<<"l3:";
	for(list<int>::iterator i=l3.begin(); i!=l3.end(); i++) {
		cout<<*i<<" ";
	}
	cout<<endl;
}
