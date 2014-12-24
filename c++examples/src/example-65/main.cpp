#include <set>
#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <map>
#include <cstdlib>
#include <unistd.h>
#include <time.h>
#include <numeric>
#include <queue>

using namespace std;

struct message {
	string text;
	int p;

	bool operator < (const message & m) const {
		return this->p < m.p;
	}

	friend ostream & operator << (ostream & os, const message & m) {
		os<<'['<<m.text<<", "<<m.p<<']';
		return os;
	}
};

int main(int argc, char **argv) {

	priority_queue<float> q;
	// insert three elements into the priority queue
	q.push(66.6);
	q.push(22.2);
	q.push(44.4);
	// read and print two elements
	cout << q.top() << ' ';
	q.pop();
	cout << q.top() << endl;
	q.pop();
	// insert three more elements
	q.push(11.1);
	q.push(55.5);
	q.push(33.3);
	// skip one element
	q.pop();
	// pop and print remaining elements
	while (!q.empty()) {
		cout << q.top() << ' ';
		q.pop();
	}
	cout << endl;

	priority_queue<message> mq;

	mq.push( { "hello", 0 });
	mq.push( { "пойдешь курить?", 1 });
	mq.push( { "sam hello", 0 });
	mq.push( { "зарплата !!!!11111", 2 });
	mq.push( { ":)", 0 });

	while(!mq.empty()) {
		cout<<mq.top()<<" ";
		mq.pop();
	}
	cout<<endl;

	return 0;
}

