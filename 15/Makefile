CXX=g++
CXX_FLAGS=-g -O0
LD=g++
LD_FLAGS=

all: 15

15: 15.o
	$(LD) $(LD_FLAGS) $^ -o $@

%.o: %.cpp
	$(CXX) $(CXX_FLAGS) -c $<

clean:
	rm -rf *.o 15
