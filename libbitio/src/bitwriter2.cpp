#include "../include/bitio/bitwriter2.h"

#include <cstring>

const unsigned char bitwriter2::MASKS[8] = {0x80, 0x40, 0x20, 0x10, 0x08, 0x04, 0x02, 0x01};

bitwriter2::bitwriter2() {
	reset();
}

void
bitwriter2::write(std::ostream & os, const void * data, int len) {
	unsigned char * c = (unsigned char *) data;
	unsigned char bitno = 0;
	for(int i=0; i<len; i++) {
		addbit(os, (*c) & MASKS[bitno]);
		bitno++;
		if(bitno == 8) {
			c++;
			bitno = 0;
		}
	}
	return;
}

void
bitwriter2::flush(std::ostream & os) {

	while(bits != 0) {
		addbit(os, 0);
	}

	return;
}

void
bitwriter2::addbit(std::ostream & os, int bit) {
	buffer[bits] = bit ? 1 : 0;
	bits++;
	if(bits == 8) {
		unsigned char byte = buffer.to_ulong();
		os.put(byte);
		//reset();
		bits = 0;
	}
	return;
}

void
bitwriter2::reset() {
	bits = 0;
	buffer.reset();
}
