#include <iostream>

#define private public
#include "myclass.h"

using namespace std;

int main(int argc, char **argv) {

	myclass a;

	a.x = 10;
	a.y = 20;

	return 0;
}
