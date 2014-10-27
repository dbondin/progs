#include<string>
#include<map>
#include<iostream>
#include<fstream>

using namespace std;

int main(int argc, char **argv) {

	if(argc < 2) {
		cerr<<"filename required !!!"<<endl;
		return 1;
	}

	ifstream is(argv[1]);

	if(!is.good()) {
		cerr<<"error opening file '"<<argv[1]<<"'"<<endl;
		return 1;
	}

	map<string, int> dic;

	while(true) {
		string s;
		is>>s;
		if(!is.good()) {
			break;
		}
		dic[s]++;
	}

	for(map<string, int>::const_iterator i = dic.begin(); i != dic.end(); ++i) {
		cout<<(*i).first<<" "<<(*i).second<<endl;
	}

	is.close();

	return 0;
}
