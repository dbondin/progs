#ifndef __BITWRITER2_H__
#define __BITWRITER2_H__

#include<ostream>
#include<bitset>

class bitwriter2 {

public:

	bitwriter2();
	void write(std::ostream & os, const void * data, int len);
	void flush(std::ostream & os);

private:

	static const unsigned char MASKS[8];

	void reset();
	void addbit(std::ostream & os, int bit);

	std::bitset<8> buffer;
	int bits;
};



#endif /* __BITWRITER2_H__ */
