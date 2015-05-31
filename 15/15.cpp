#include <vector>
#include <iostream>
#include <cstring>
#include <cmath>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>

#ifdef DEBUG
#define DPRINT( x ) { cout << "DPRINT: " << (x) << endl; }
#define DPRINT2( x, y ) { cout << "DPRINT: " << (x) << " " << (y) << endl; }
#else /* DEBUG */
#define DPRINT( x ) { }
#define DPRINT2( x, y ) { }
#endif /* DEBUG */

#define WIDTH 3
#define HEIGHT 3
#define NUM ( WIDTH * HEIGHT )

using namespace std;

struct Pos {
	unsigned char data[NUM];
	unsigned char zeroPos;
	unsigned long int parent;
};

struct PosList {
	Pos * list;
	unsigned long int size;
};

void initSolutions();
bool check(Pos & pos);
void swap(Pos & pos, int index1, int index2);
void markExist(Pos & pos);
void addPos(Pos & pos);
void moveLeft(int index);
void moveRight(int index);
void moveUp(int index);
void moveDown(int index);
int doit(int index);
void printPos(Pos & pos);
unsigned long int factorial(unsigned long int value);
void makeRandomPos(Pos & pos);

PosList posList;
unsigned char * exist;
vector<Pos> solutions;
unsigned long int posListMax = factorial(NUM) / 2;
unsigned long long int existMax = (unsigned long long int) pow(NUM, NUM);

void makeRandomPos(Pos & pos) {
	srand(time(NULL));
	for(int i=0; i<NUM; i++) {
		pos.data[i] = i;
	}
	for(int i=0; i<NUM; i++) {
		swap(pos, i, rand() % NUM);
	}
	for(int i=0; i<NUM; i++) {
		if(pos.data[i] == 0) {
			pos.zeroPos = i;
		}
	}
	pos.parent = -1;
}

void initSolutions() {
	Pos sol1;
	Pos sol2;

	sol1.parent = -1;
	sol2.parent = -1;
	sol1.zeroPos = NUM - 1;
	sol2.zeroPos = NUM - 1;

	for(int i=0; i<NUM - 1; i++) {
		sol1.data[i] = i + 1;
		if(i == (NUM - 2)) {
			sol2.data[i] = NUM - 2;
		}
		else if(i == (NUM - 3)) {
			sol2.data[i] = NUM - 1;
		}
		else {
			sol2.data[i] = i + 1;
		}
	}
	sol1.data[NUM - 1] = 0;
	sol2.data[NUM - 1] = 0;

	solutions.push_back(sol1);
	solutions.push_back(sol2);
}

bool check(Pos & pos) {
	for(vector<Pos>::iterator iter = solutions.begin(); iter != solutions.end(); iter ++) {
		if(memcmp(pos.data, (*iter).data, sizeof(pos.data)) == 0) {
			return true;
		}
	}
	return false;
}

void swap(Pos & pos, int index1, int index2) {
	unsigned char tmp = pos.data[index1];
	pos.data[index1] = pos.data[index2];
	pos.data[index2] = tmp;
}

void markExist(Pos & pos) {

	int existIndex = 0;
	for(int i=0; i<NUM; i++) {
		existIndex *= NUM;
		existIndex += pos.data[i];
	}

	exist[existIndex] = 1;
}

bool isExist(Pos & pos) {

	unsigned long long int existIndex = 0;
	for(int i=0; i<NUM; i++) {
		existIndex *= NUM;
		existIndex += pos.data[i];
	}

	if(existIndex >= existMax) {
		cerr<<"existMax overfull ("<<existIndex<<"/"<<existMax<<")"<<endl;
		return true;
	}

	return exist[existIndex];
}

void addPos(Pos & pos) {
	if(!isExist(pos)) {
		if(posList.size >= posListMax) {
			cerr<<"posListMax overfill !!!"<<endl;
			return;
		}
		posList.list[posList.size] = pos;
		posList.size ++;
		markExist(pos);
		DPRINT2("size =", posList.size);
	}
}

void moveLeft(int index) {
	Pos pos = posList.list[index];
	if((pos.zeroPos % WIDTH) != 0) {
		Pos newPos;
		newPos.parent = index;
		newPos.zeroPos = pos.zeroPos - 1;
		memcpy(newPos.data, pos.data, sizeof(pos.data));
		swap(newPos, pos.zeroPos, newPos.zeroPos);
		addPos(newPos);
	}
}

void moveRight(int index) {
	Pos pos = posList.list[index];
	if((pos.zeroPos % WIDTH) != (WIDTH - 1)) {
		Pos newPos;
		newPos.parent = index;
		newPos.zeroPos = pos.zeroPos + 1;
		memcpy(newPos.data, pos.data, sizeof(pos.data));
		swap(newPos, pos.zeroPos, newPos.zeroPos);
		addPos(newPos);
	}
}

void moveUp(int index) {
	Pos pos = posList.list[index];
	if(pos.zeroPos >= WIDTH) {
		Pos newPos;
		newPos.parent = index;
		newPos.zeroPos = pos.zeroPos - WIDTH;
		memcpy(newPos.data, pos.data, sizeof(pos.data));
		swap(newPos, pos.zeroPos, newPos.zeroPos);
		addPos(newPos);
	}
}

void moveDown(int index) {
	Pos pos = posList.list[index];
	if(pos.zeroPos < (NUM - WIDTH)) {
		Pos newPos;
		newPos.parent = index;
		newPos.zeroPos = pos.zeroPos + WIDTH;
		memcpy(newPos.data, pos.data, sizeof(pos.data));
		swap(newPos, pos.zeroPos, newPos.zeroPos);
		addPos(newPos);
	}
}

int doit(int index) {
	unsigned long int size = posList.size;
	DPRINT2("doit", index);
	for(int i=index; i < size; i++)
	{
		if(check(posList.list[i])) {
			DPRINT("doit found !!!");
			return i;
		}
	}
	for(int i=index; i < size; i++)
	{
		moveUp(i);
		moveRight(i);
		moveDown(i);
		moveLeft(i);
	}
	if(size == posList.size) {
		return -1;
	}
      	return doit(size);
}

void printPos(Pos & pos) {
	for(int i=0; i<HEIGHT; i++) {
		if(i == 0) {
			cout<<"/ ";
		}
		else {
			cout<<"  ";
		}
		for(int j=0; j<WIDTH; j++) {
			if(pos.data[i * WIDTH + j] == 0) {
				cout<<"_ ";
			}
			else {
				cout<<(int)pos.data[i * WIDTH + j]<<" ";
			}
		}
		cout<<endl;
	}
}

unsigned long int factorial(unsigned long int value) {
	if(value < 2) {
		return 1;
	}
	return value * factorial(value - 1);
}

int main(int argc, char **argv) {
	exist = new unsigned char [existMax];
	posList.list = new Pos[posListMax];
	posList.size = 0;
	initSolutions();
	Pos p0;
	makeRandomPos(p0);
	cout<<"Initial position:"<<endl;
	printPos(p0);
	cout<<"Final positions:"<<endl;
	printPos(solutions[0]);
	printPos(solutions[1]);
	cout<<"Exist max size: "<<existMax<<endl;
	cout<<"PosList max size: "<<posListMax<<endl;
	addPos(p0);
	int index = doit(0);
	if(index == -1) {
		cout<<"No solution found. "<<posList.size<<" combinations checked. Exiting."<<endl;
	}
	else {
		vector<int> st;
		while(index != -1) {
			st.push_back(index);
			index = posList.list[index].parent;
		}

		while(!st.empty()) {
			int index = st.back();
			st.pop_back();
			cout<<"index = "<<index<<endl;
			printPos(posList.list[index]);
		}
	}

	delete [] posList.list;
	delete [] exist;
}
