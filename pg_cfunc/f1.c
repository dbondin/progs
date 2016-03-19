#include <stdlib.h>
#include <string.h>

#include "f1.h"

char * f1(const char * str) {
	char * result = NULL;
	if(str != NULL) {
		int i;
		int len = strlen(str);
		result = (char *) malloc(len + 1);
		for(i=0; i<len; i++) {
			result[i] = str[len - i - 1];
		}
		result[len] = 0;
	}
	return result;
}
