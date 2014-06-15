INST_PATH=/usr/local/bin

CC = gcc
CFLAGS = -g
LD = gcc
LDFLAGS =

RM = rm -rf
CP = cp

all: ru2trans

ru2trans.o: ru2trans.c ru2trans_tbl.h

ru2trans: ru2trans.o ru2trans_tbl.o
	$(LD) $(LDFLAGS) $(^) -o $(@)

mkru2trans_tbl: mkru2trans_tbl.o
	$(LD) $(LDFLAGS) $(^) -o $(@)

ru2trans_tbl.c: mkru2trans_tbl
	./$(<) > $(@)

clean:
	$(RM) *.o ru2trans_tbl.c mkru2trans_tbl *~ ru2trans

install: ru2trans
	$(CP) $(^) $(INST_PATH)

%.o: %.c
	$(CC) $(CFLAGS) -c $(<) -o $(@)
