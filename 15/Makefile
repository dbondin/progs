CXX=g++
CXXFLAGS=-g -O0
LD=g++
LDFLAGS=

all: 15

15: 15.o
	$(LD) $(LDFLAGS) $^ -o $@

%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $<

clean:
	rm -rf *.o 15
