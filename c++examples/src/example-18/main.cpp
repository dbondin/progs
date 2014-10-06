#include<iostream>
#include<string>

using namespace std;

template <class T>
void exchange(T & a, T & b) {
	T tmp = a;
	a = b;
	b = tmp;
}

template <class T>
void sorting(T array [], int size) {
	for(int i=0; i<size; i++) {
		for(int j=0; j<size-i-1; j++) {
			if(array[j] > array[j+1]) {
				exchange(array[j], array[j+1]);
			}
		}
	}
}

template <class T>
void print(T array [], int size) {
	for(int i=0; i<size; i++) {
		cout<<array[i];
		if(i != size-1) {
			cout<<',';
		}
	}
	cout<<endl;
}

class rectangular {
public:
	rectangular(string name = "",
			double x = 0.0,
			double y = 0.0,
			double width = 0.0,
			double height = 0.0) {
		this->name = name;
		this->x = x;
		this->y = y;
		this->width = width;
		this->height = height;
	}
	double square() const {
		return width * height;
	}
	friend ostream & operator <<(ostream & os, rectangular & r) {
		os<<r.name;
		return os;
	}
	bool operator >(rectangular & r) {
		return square() > r.square();
	}
private:
	string name;
	double x;
	double y;
	double width;
	double height;
};

int main(int argc, char **argv) {

	int ai [] = {2, 454, 65, 23, 654, 675, 23, 54, 2, 8, 54, 9};

	print(ai,sizeof(ai)/sizeof(ai[0]));
	sorting(ai, sizeof(ai)/sizeof(ai[0]));
	print(ai,sizeof(ai)/sizeof(ai[0]));

	string as [] = {"hello", "world", "one", "two", "three"};
	print(as, sizeof(as)/sizeof(as[0]));
	sorting(as, sizeof(as)/sizeof(as[0]));
	print(as, sizeof(as)/sizeof(as[0]));

	rectangular ar [5];
	ar[0] = rectangular("D", 3, 3, 2, 1);
	ar[1] = rectangular("A", 0, 0, 1, 1);
	ar[2] = rectangular("C", 2, 2, 1, 2);
	ar[3] = rectangular("E", 5, 3, 2, 2);
	ar[4] = rectangular("B", 1, 1, 1, 1);
	print(ar, sizeof(ar)/sizeof(ar[0]));
	sorting(ar, sizeof(ar)/sizeof(ar[0]));
	print(ar, sizeof(ar)/sizeof(ar[0]));

	return 0;
}
