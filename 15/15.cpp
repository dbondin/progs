#include <vector>
#include <iostream>
#include <cstring>
#include <cmath>
#include <unistd.h>

#if 1
#define DPRINT(x) { cout << "DPRINT: " << (x) << endl; }
#else
#define DPRINT(x) { }
#endif

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

PosList posList;
unsigned char * exist;

Pos sol1 = {{1, 2, 3, 4, 5, 6, 7, 8, 0}, 8, -1};
Pos sol2 = {{1, 2, 3, 4, 5, 6, 8, 7, 0}, 8, -1};

vector<Pos> solutions;

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

	solutions.push_back(sol1);
	solutions.push_back(sol2);
}

bool check(Pos & pos) {
	for(vector<Pos>::iterator iter = solutions.begin(); iter != solutions.end(); iter ++) {
		if(memcmp(pos.data, (*iter).data, sizeof(pos.data)) != 0) {
			return false;
		}
	}
	return true;
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

	int existIndex = 0;
	for(int i=0; i<NUM; i++) {
		existIndex *= NUM;
		existIndex += pos.data[i];
	}

	return exist[existIndex];
}

void addPos(Pos & pos) {
	if(!isExist(pos)) {
		posList.list[posList.size] = pos;
		posList.size ++;
		markExist(pos);
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
	DPRINT("move right 1");
	if((pos.zeroPos % WIDTH) != (WIDTH - 1)) {
		DPRINT("move right 2");
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

	DPRINT("doit 1");
	DPRINT(index);
	for(int i=index; i < posList.size; i++)
	{
		DPRINT("doit 3");
		Pos pos = posList.list[i];
		if(check(pos)) {
			DPRINT("doit found !!!");
			return i;
		}
	}
	DPRINT("doit 2");
	for(int i=index; i < posList.size; i++)
	{
		moveUp(i);
		moveRight(i);
		moveDown(i);
		moveLeft(i);
	}

	return doit(posList.size);
}

void printPos(Pos & pos) {
	for(int i=0; i<HEIGHT; i++) {
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

Pos pos0 = {{ 5, 4, 3, 2, 1, 0}, 5, -1};

unsigned long int factorial(unsigned long int value) {
	if(value < 2) {
		return 1;
	}
	return value * factorial(value - 1);
}

int main(int argc, char **argv) {
	exist = new unsigned char [(int)pow(NUM, NUM)];
	posList.list = new Pos[factorial(NUM) / 2];
	posList.size = 0;
	initSolutions();
	cout<<"MAX LIST SIZE = "<<(factorial(NUM) / 2)<<endl;
	printPos(solutions[0]);
	printPos(solutions[1]);
	addPos(pos0);
	int index = doit(0);
	vector<int> st;
	while(index != -1) {
		st.push_back(index);
		index = posList.list[index].parent;
	}

	while(!st.empty()) {
		int index = st.back();
		st.pop_back();
		cout<<"index ="<<index<<endl;
		printPos(posList.list[index]);
	}
}
