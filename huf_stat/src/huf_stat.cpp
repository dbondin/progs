#include <iostream>
#include <fstream>
#include <string>
#include <list>
#include <algorithm>
#include <sstream>

#include <arpa/inet.h>

#include <bitio/bitio.h>

#include "TreeNode.hpp"
#include "TreeNodePtrComparator.hpp"

using namespace std;

struct TheCode {
	unsigned char buff[32]; // 256 == 32 * 8
	int len;
};

void printUsage(ostream & out) {
	out << "Usage: huf_stat c|d infile outfile" << endl;
	out << "       huf_stat t infile" << endl;
	out << "         c - for compress" << endl;
	out << "         d - for decompress" << endl;
	out << "         t - for tree testing" << endl;
}

TreeNode * makeTree(unsigned long * stats) {

	list<TreeNode*> forest;

	for (int i = 0; i < 256; i++) {
		TreeNode * tn = new TreeNode(i, stats[i]);
		forest.push_back(tn);
	}

	while (forest.size() != 1) {
		list<TreeNode*>::iterator iter = min_element(forest.begin(),
				forest.end(), TreeNodePtrComparator());
		TreeNode * firstTree = *iter;
		forest.erase(iter);
		iter = min_element(forest.begin(), forest.end(),
				TreeNodePtrComparator());
		TreeNode * secondTree = *iter;
		forest.erase(iter);
		TreeNode * tn = new TreeNode(firstTree, secondTree);
		forest.push_back(tn);
	}

	return forest.front();
}

void countStats(istream & in, unsigned long * stats) {

	for (int i = 0; i < 256; i++) {
		stats[i] = 0L;
	}
	unsigned char buffer[4096];
	while (true) {
		in.read((char *)buffer, 4096);
		int readBytes = in.gcount();
		for(int i=0; i<readBytes; i++) {
			stats[buffer[i]]++;
		}
		if (in.eof()) {
			break;
		}
	}

	return;
}

void makeCodes(const TreeNode * node, TheCode * codes, string bitstring = "") {
	if (node->getType() == TreeNode::LEAF) {
		codes[node->getByte()].len = bitstring.length();
		int i = bitstring.length() - 1;
		for (string::const_iterator c = bitstring.begin(); c != bitstring.end();
				c++) {
			if (*c == '1') {
				bitops::set_bit(codes[node->getByte()].buff, i);
			} else {
				bitops::unset_bit(codes[node->getByte()].buff, i);
			}
			i--;
		}
	} else {
		makeCodes(node->getLeft(), codes, bitstring + "0");
		makeCodes(node->getRight(), codes, bitstring + "1");
	}
}

void writeStats(ofstream & ofs, unsigned long * stats) {
	for (int i = 0; i < 256; i++) {
		unsigned long be = htonl(stats[i]);
		ofs.write((const char *) &be, 4);
	}
}

void writeMagic(ofstream & ofs, const string & magic) {
	ofs.write(magic.data(), magic.length());
}

bool readAndCheckMagic(ifstream & ifs, const string & magic) {
	int len =magic.length();
	char buffer[len];
	ifs.read(buffer, len);
	if(!ifs.good()) {
		return false;
	}
	for(int i=0; i<len; i++) {
		if(buffer[i] != magic[i]) {
			return false;
		}
	}
	return true;
}

bool readStats(ifstream * ifs, unsigned long * stats) {
	char buffer[1024];
	ifs->read(buffer, 1024);
	if(!ifs->good()) {
		return false;
	}
	for(int i=0; i<256; i++) {
		stats[i] = ntohl(*((unsigned long *)(buffer + 4*i)));
	}
	return true;
}

void compress(const string & infile, const string & outfile) {
	ifstream ifs(infile.c_str());
	if (!ifs.good()) {
		cerr << "Error opening file " << infile << " for reading" << endl;
		return;
	}
	unsigned long stats[256];
	cout << "Calculating input file statistics" << endl;
	countStats(ifs, stats);
	ifs.clear();
	ifs.seekg(0, ios::beg);
	cout << "Creating huffman tree" << endl;
	TreeNode * tree = makeTree(stats);
	cout << "Creating codes from tree" << endl;
	TheCode codes[256];
	makeCodes(tree, codes);
	cout << "Compressing" << endl;
	ofstream ofs(outfile.c_str(), ios::binary);
	writeStats(ofs, stats);
	bitwriter bw;
	bw.attach(ofs);
	//bitwriter2 bw2;
	unsigned char buffer[4096];
	while (true) {
		ifs.read((char *)buffer, 4096);
		int readBytes = ifs.gcount();
		for(int i=0; i<readBytes; i++) {
			TheCode & code = codes[buffer[i]];
			bw.write((void *) code.buff, code.len);
			//bw2.write(ofs, (void *) code.buff, code.len);
		}
		if (!ifs.good()) {
			break;
		}
	}
	bw.flush();
	bw.detach();
	//bw2.flush(ofs);
	ofs.close();
	cout << "Done" << endl;
}

void decompress(const string & infile, const string & outfile) {

}

string codeToString(const TheCode & code) {
	ostringstream ss;
	for (int i = code.len - 1; i >= 0; i--) {
		ss << (bitops::is_bit_set(code.buff, i) ? '1' : '0');
	}
	return ss.str();
}

void testtree(const string & infile) {
	ifstream ifs(infile.c_str());
	if (!ifs.good()) {
		cerr << "Error opening file " << infile << " for reading" << endl;
		return;
	}
	unsigned long stats[256];
	cout << "Calculating input file statistics" << endl;
	countStats(ifs, stats);
	ifs.clear();
	ifs.seekg(0, ios::beg);
	cout << "Creating huffman tree" << endl;
	TreeNode * tree = makeTree(stats);
	cout << "Creating codes from tree" << endl;
	TheCode codes[256];
	makeCodes(tree, codes);
	unsigned long int size = 0;
	for (int i = 0; i < 256; i++) {
		size += stats[i];
		cout << i << "\t" << stats[i] << '\t' << codeToString(codes[i]) << '\t'
				<< codes[i].len;
		if (i >= 32 && i < 128) {
			// ASCII
			cout << '\t' << '\'' << (unsigned char) i << '\'';
		}
		cout << endl;
	}
	cout << "Total len: " << size << endl;
	cout << "Done" << endl;
}

int main(int argc, char **argv) {

	if (argc < 2) {
		printUsage(cerr);
		return 1;
	}

	string mode = argv[1];

	if (mode == "c" && argc == 4) {
		compress(argv[2], argv[3]);
	} else if (mode == "d" && argc == 4) {
		decompress(argv[2], argv[3]);
	} else if (mode == "t" && argc == 3) {
		testtree(argv[2]);
	} else {
		printUsage(cerr);
		return 1;
	}

	return 0;
}
