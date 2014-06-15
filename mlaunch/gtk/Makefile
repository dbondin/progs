CC=gcc
CFLAGS=-Wall -O2 `pkg-config gtk+-2.0 --cflags`
LD=gcc
LDFLAGS=`pkg-config gtk+-2.0 --libs`
RM=rm -rf

all: mlaunch-gtk

mlaunch-gtk: main.o
	$(LD) $(LDFLAGS) -o $(@) $(^)

%.o: %.c
	$(CC) $(CFLAGS) -c -o $(@) $(<)

clean:
	$(RM) *.o mlaunch-gtk
