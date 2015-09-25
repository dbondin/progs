#include <iostream>
#include <cstring>

int main(int argc, char **argv) {
	char str1[] = "ABCD";
	char str2[10] = {0};
	char str3[] = "abc";
	char str4[] = "abc";
	char * p;

	char * str_copy = strdup("ABCD");

	std::cout<<str1<<' '<<str_copy<<std::endl;
	std::cout<<((unsigned long)str1)<<' '<<((unsigned long)str_copy)<<std::endl;

	free(str_copy);

	strncpy(str2, "ABCDEFGHIJKLMN", 9);

	std::cout<<str2<<std::endl;

	std::cout<<strcmp("abc", "abc")<<std::endl;
	std::cout<<strcmp("abc", "bbc")<<std::endl;
	std::cout<<strcmp("bbc", "abc")<<std::endl;

	if(str3 == str4) {
		std::cout<<":)"<<std::endl;
	}
	else {
		std::cout<<":("<<std::endl;
	}
	if(!strcmp(str3, str4)) {
		std::cout<<":)"<<std::endl;
	}
	else {
		std::cout<<":("<<std::endl;
	}

	for(p=str3; (*p)!=0; p++) {
		std::cout<<*p<<std::endl;
		std::cout<<(int)*p<<std::endl;
	}
}
