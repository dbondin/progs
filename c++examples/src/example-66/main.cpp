#include <algorithm>
#include <iostream>
#include <string>
#include <iterator>
#include <bitset>

using namespace std;

int main(int argc, char **argv) {

	bitset<4> bs;

	cout<<bs<<endl;

	bs[2] = 1;

	cout<<bs<<endl;

	cout<<bs[3]<<endl;

	cout<<bs.any()<<endl;

	cout<<bs.all()<<endl;

	cout<<bs.flip()<<endl;

	bs.flip(0);
	cout<<bs<<endl;

	cout<<bs.count()<<endl;

	return 0;
}

