CC=gcc
CFLAGS=-Wall -O2
LD=gcc
LDFLAGS=-L. -lcommon
AR=ar rcs
RM=rm -rf

all: libcommon.a test

libcommon.a: common.o
	$(AR) $(@) $(^)

test: test.o
	$(LD) -o $(@) $(^) $(LDFLAGS)

%.o: %.c
	$(CC) $(CFLAGS) -c -o $(@) $(<)

clean:
	$(RM) libcommon.a *.o test

test.c: common.h
common.c: common.h
