all: test_static test_shared test_dynamic test_cpp

test_static: test_static.c
	gcc -static -I./libcalculator test_static.c -L./libcalculator -o test_static -lcalculator

test_shared: test_shared.c
	gcc -I./libcalculator test_shared.c -L./libcalculator -o test_shared -lcalculator -Wl,-rpath=/home/stuff/dbondin/calculator/libcalculator

test_cpp: test_cpp.cpp
	g++ -I./libcalculator test_cpp.cpp -L./libcalculator -o test_cpp -lcalculator -Wl,-rpath=/home/stuff/dbondin/calculator/libcalculator

test_dynamic: test_dynamic.c
	gcc test_dynamic.c -o test_dynamic -ldl

clean:
	rm -rf test_static test_shared test_dynamic test_cpp
