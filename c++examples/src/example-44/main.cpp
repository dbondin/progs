#include <iostream>
#include <string>
#include <memory>
#include <dirent.h>
#include <cstring>
#include <cerrno>
using namespace std;

class DirCloser {
public:
	void operator ()(DIR* dp) {
		if (closedir(dp) != 0) {
			std::cerr << "OOPS: closedir() failed" << std::endl;
		}
		else {
			std::cout<<"DirCloser ok"<<std::endl;
		}
	}
};
int x() {
// open current directory:
	unique_ptr<DIR, DirCloser> pDir(opendir("."));

/*	unique_ptr<DIR, [] (DIR * dp) {
		if (closedir(dp) != 0) {
			std::cerr << "OOPS: closedir() failed" << std::endl;
		}
		else {
			std::cout<<"DirCloser ok"<<std::endl;
		}
	}> pDir(opendir("."));*/

// process each directory entry:
	struct dirent *dp;
	throw 1;
	while ((dp = readdir(pDir.get())) != nullptr) {
		//string filename(dp->d_name);
		cout << "process " << dp->d_name << endl;
	}
}

int main(int argc, char **argv) {
	x();
}
