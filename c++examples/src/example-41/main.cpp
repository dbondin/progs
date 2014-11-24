#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <iterator>
#include <string>
#include <stdlib.h>

using namespace std;

const int A_SIZE = 200000;

void f() {
	int * a = new int[A_SIZE];

	for(int i=0; i<A_SIZE; i++) {
		a[i] = i * i;
	}

	delete [] a;
}

int main(int argc, char **argv) {

	while(true) {
		f();
		system("sleep 1");
	}

	return 0;
}
