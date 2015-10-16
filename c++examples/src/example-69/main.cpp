#include <string>
#include <map>
#include <iostream>
#include <tuple>

using namespace std;

int main(int argc, char **argv) {
	pair<int, string> p1(1, "Петя");
	cout<<p1.first<<" "<<p1.second<<endl;
	tuple<int,float,string> t1(41,6.3,"nico");
	cout<<get<0>(t1)<<endl;
	tuple<int, string> t2(p1);
	return 0;
}
