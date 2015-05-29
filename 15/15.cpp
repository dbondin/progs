#include <vector>
#include <iostream>
#include <cstring>
#include <cmath>
#include <unistd.h>

#if 0
#define XXX(x) { cout << (x) << endl; }
#else
#define XXX(x) { }
#endif

#define WIDTH 3
#define HEIGHT 2
#define NUM ( WIDTH * HEIGHT )

using namespace std;

struct Pos {
	unsigned char data[NUM];
	unsigned char zeroPos;
	int parent;
};

unsigned char * exist;

Pos sol1 = {{1, 2, 3, 4, 5, 0}, 5, -1};
Pos sol2 = {{1, 2, 3, 5, 4, 0}, 5, -1};

bool check(Pos & pos) {
	if(memcmp(pos.data, sol1.data, sizeof(pos.data)) == 0 ||
			memcmp(pos.data, sol2.data, sizeof(pos.data)) == 0) {
		return true;
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

	int existIndex = 0;
	for(int i=0; i<NUM; i++) {
		existIndex *= NUM;
		existIndex += pos.data[i];
	}

	return exist[existIndex];
}

void addPos(vector<Pos> & posList, Pos & pos) {
	if(!isExist(pos)) {
		posList.push_back(pos);
		markExist(pos);
	}
}

void moveLeft(vector<Pos> & posList, int index) {
	Pos pos = posList[index];
	if((pos.zeroPos % WIDTH) != 0) {
		Pos newPos;
		newPos.parent = index;
		newPos.zeroPos = pos.zeroPos - 1;
		memcpy(newPos.data, pos.data, sizeof(pos.data));
		swap(newPos, pos.zeroPos, newPos.zeroPos);
		posList.push_back(newPos);
	}
}

void moveRight(vector<Pos> & posList, int index) {
	Pos pos = posList[index];
	XXX("right 1");
	if((pos.zeroPos % WIDTH) != (WIDTH - 1)) {
		XXX("right 2");
		Pos newPos;
		newPos.parent = index;
		newPos.zeroPos = pos.zeroPos + 1;
		memcpy(newPos.data, pos.data, sizeof(pos.data));
		swap(newPos, pos.zeroPos, newPos.zeroPos);
		posList.push_back(newPos);
	}
}

void moveUp(vector<Pos> & posList, int index) {
	Pos pos = posList[index];
	if(pos.zeroPos >= WIDTH) {
		Pos newPos;
		newPos.parent = index;
		newPos.zeroPos = pos.zeroPos - WIDTH;
		memcpy(newPos.data, pos.data, sizeof(pos.data));
		swap(newPos, pos.zeroPos, newPos.zeroPos);
		posList.push_back(newPos);
	}
}

void moveDown(vector<Pos> & posList, int index) {
	Pos pos = posList[index];
	if(pos.zeroPos < (NUM - WIDTH)) {
		Pos newPos;
		newPos.parent = index;
		newPos.zeroPos = pos.zeroPos + WIDTH;
		memcpy(newPos.data, pos.data, sizeof(pos.data));
		swap(newPos, pos.zeroPos, newPos.zeroPos);
		posList.push_back(newPos);
	}
}

int doit(vector<Pos> & posList, int index) {

	int size = posList.size();
	XXX("doit1");
	for(int i=index; i < size; i++)
	{
		XXX("doit3");
		Pos pos = posList[i];
		if(check(pos)) {
			XXX("doit found !!!");
			return i;
		}
	}
	XXX("doit2");
	for(int i=index; i < size; i++)
	{
		moveUp(posList, i);
		moveRight(posList, i);
		moveDown(posList, i);
		moveLeft(posList, i);
	}

	return doit(posList, size);
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

int main(int argc, char **argv) {
	exist = new unsigned char [(int)pow(NUM, NUM)];
	vector<Pos> posList;
	addPos(posList, pos0);
	int index = doit(posList, 0);
	vector<int> st;
	while(index != -1) {
		st.push_back(index);
		index = posList[index].parent;
	}

	while(!st.empty()) {
		int index = st.back();
		st.pop_back();
		cout<<"index ="<<index<<endl;
		printPos(posList[index]);
	}

	//sleep(1000);
}
