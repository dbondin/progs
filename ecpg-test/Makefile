all: test1

test1: test1.o
	gcc -o $@ $^ -lecpg

%.o: %.c
	gcc -c $<

%.c: %.pgc
	ecpg $<

clean:
	rm -rf test1 *.o test1.c *~
