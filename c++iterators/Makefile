CXX=g++
CXXFLAGS=-g -O0
LD=g++
LDFLAGS=

TARGET=main

OBJS=main.o

all: $(TARGET)

$(TARGET): $(OBJS)
	$(LD) $(LDFLAGS) $^ -o $@

%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $<

clean:
	rm -rf $(OBJS) $(TARGET) *~
