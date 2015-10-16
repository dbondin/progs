#include<string>
#include<iostream>

using namespace std;

int main(int argc, char **argv) {

	if(argc < 2) {
		cerr<<"Encryption key required !!!"<<endl;
		return 1;
	}

	int keyIndex = 0;
	string key(argv[1]);

	while(true) {
		int c = cin.get();
		if(cin.eof()) {
			break;
		}
		int ec = c ^ key[keyIndex];
		cout.put(ec);
		keyIndex ++;
		if(keyIndex >= key.length()) {
			keyIndex = 0;
		}
	}

	return 0;
}
