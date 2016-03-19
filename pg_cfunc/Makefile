PG_CONFIG=/usr/local/bin/pg_config
CC=gcc
CXX=g++
LD=g++
CPPFLAGS=-I$(shell $(PG_CONFIG) --includedir-server)
CFLAGS=-Wall -Werror $(shell pg_config --cflags_sl)
CXXFLAGS=-Wall -Werror $(shell pg_config --cflags_sl)
LDFLAGS=$(shell pg_config --ldflags_sl)

TARGET=libpg_func.so

OBJS=f1.o \
     f2.o \
     pg_wrapper.o

all: $(TARGET)

$(TARGET): $(OBJS)
	$(LD) $(LDFLAGS) -shared -o $(@) $(^)

%.o: %.c
	$(CC) $(CPPFLAGS) $(CFLAGS) -c $(<)

%.o: %.cpp
	$(CXX) $(CPPFLAGS) $(CXXFLAGS) -c $(<)

clean:
	rm -rf $(TARGET) $(OBJS)

mrproper: clean
	rm -rf *~
