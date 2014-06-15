CC=gcc
LD=gcc
AR=ar
RM=rm -rf
CFLAGS=-fpic
LDFLAGS=

all: libmyprintf.so

libmyprintf.so: myprintf.o
	$(LD) -shared -o $@ $^

%.o: %.c
	$(CC) $(CFLAGS) -c $<

clean:
	$(RM) *.o libmyprintf.so
