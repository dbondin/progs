all: mongoose-test

mongoose-test: mongoose-test.o
	gcc -o $@ $^ -lmongoose

%.o: %.c
	gcc -c $<

clean:
	rm -rf mongoose-test *.o *~
