#include <string>
#include <algorithm>

#include "f2.h"

std::string f2(const std::string & str) {
	std::string result(str.length(), 0);
	std::reverse_copy(str.begin(), str.end(), result.begin());
	return result;
}
