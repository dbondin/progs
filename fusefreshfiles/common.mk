CC=gcc
CFLAGS=-Wall $(shell pkg-config --cflags fuse)
LD=gcc
LDFLAGS=$(shell pkg-config --libs fuse)
RMRF=rm -fr
SED=sed
MAKEDEPEND=cpp -MM

SRC=$(OBJS:.o=.c)
DEPS=$(OBJS:.o=.d)

$(TARGET): $(OBJS)
	$(LD) -o $@ $^ $(LDFLAGS)

%.o: %.c
	$(CC) $(CFLAGS) -c -o $@ $<

%.d: %.c
	$(RMRF) $@ && \
	$(MAKEDEPEND) $(CFLAGS) $< > $@.$$$$ && \
	$(SED) 's,\($*\)\.o[ :]*,\1.o $@ : ,g' < $@.$$$$ > $@ && \
	$(RMRF) $@.$$$$

.PHONY: common-clean
common-clean:
	$(RMRF) $(TARGET) $(OBJS) $(DEPS)

.PHONY: depend
depend: $(DEPS)

-include $(DEPS)
