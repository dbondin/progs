LIBPQ_INC=/usr/include
LIBPQ_LIB=/usr/lib

CC=gcc
CFLAGS=-g -Wall -I$(LIBPQ_INC)
LD=gcc
LDFLAGS=-L$(LIBPQ_LIB)
RM=rm -rf

OBJS=buksa-pi.o
TARGET=buksa-pi

all: $(TARGET)

$(TARGET): $(OBJS)
	$(LD) $(LDFLAGS) -o $@ $^ -lpq

%.o: %.c
	$(CC) $(CFLAGS) -c -o $@ $<

clean:
	$(RM) $(TARGET) $(OBJS)
