#include <iostream>
#include <fstream>

using namespace std;

int main(int argc, char **argv) {

	if(argc < 2) {
		cerr<<"Не хватает имени файла"<<endl;
		return 1;
	}

	cout<<"Открываю файл '"<<argv[1]<<"'"<<endl;

	ifstream ifs(argv[1]);

	if(!ifs.is_open()) {
		cerr<<"Ошибка открытия файла '"<<argv[1]<<"'"<<endl;
		return 2;
	}

	while(true) {
		int x = ifs.get();
		if(!ifs) { // Потому-что есть std::basic_ios::operator bool() const;
			break;
		}
		cout.put(x);
	}

	ifs.close();

	return 0;
}
