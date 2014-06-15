CC=gcc
LD=gcc
AR=ar
RM=rm -rf
CFLAGS=-fpic
LDFLAGS=

all: libcalculator.a libcalculator.so

libcalculator.a: calculator.o
	$(AR) -crus $@ $^

libcalculator.so: calculator.o
	$(LD) -shared -o $@ $^

%.o: %.c
	$(CC) $(CFLAGS) -c $<

clean:
	$(RM) *.o libcalculator.a libcalculator.so
