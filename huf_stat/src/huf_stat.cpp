#include<iostream>
#include<fstream>
#include<string>

using namespace std;

class TreeNode {
public:

	enum TYPE {
		LEAF,
		INNER
	};

	TreeNode(int _byte, unsigned long int _weight);
	TreeNode(TreeNode * _left, TreeNode * _right);

	unsigned long getWeight() const;
	int getByte() const;
	TYPE getType() const;
	TreeNode * getLeft() const;
	TreeNode * getRight() const;

private:

	TYPE type;
	int byte;
	unsigned long int weight;
	TreeNode * left;
	TreeNode * right;
};

TreeNode::TreeNode(int _byte, unsigned long int _weight) : type(LEAF), byte(_byte), weight(_weight), right(NULL), left(NULL) {
}

TreeNode::TreeNode(TreeNode * _left, TreeNode * _right) : type(INNER), byte(-1), weight(_left->weight + _right->weight), left(_left), right(_right) {
}

void printUsage(ostream & out) {
	out << "Usage: huf_stat [c|d] [infile] [outfile]" << endl;
	out << "       c - for compress" << endl;
	out << "       d - for decompress" << endl;
}

void makeTree(unsigned long int * stats) {

}

void countStats(istream & in, unsigned long int * stats) {

	for(int i=0; i<256; i++) {
		stats[i] = 0L;
	}
	while(true) {
		int byte = in.get();
		if(in.eof()) {
			break;
		}
		stats[byte] ++;
	}

	return;
}

void compress(const string & infile, const string & outfile) {
	ifstream ifs(infile.c_str());
	if(!ifs.good()) {
		cerr<<"Error opening file "<<infile<<" for reading"<<endl;
		return;
	}
	unsigned long int stats [256];
	cout<<"Calculating input file statistics"<<endl;
	countStats(ifs, stats);
	ifs.seekg(0, ios::beg);
	cout<<"Creating huffman tree"<<endl;
	makeTree(stats);
	cout<<"Compressing"<<endl;
}

void decompress(const string & infile, const string & outfile) {

}

int main(int argc, char **argv) {

	if (argc != 4) {
		printUsage(cerr);
		return 1;
	}

	string mode = argv[1];
	string infile = argv[2];
	string outfile = argv[3];

	if (mode == "c") {
		compress(infile, outfile);
	}
	else if (mode == "d") {
		decompress(infile, outfile);
	}
	else {
		printUsage(cerr);
		return 1;
	}

	return 0;
}
