TARGET=fuseff
OBJS=fnames.o \
     main.o

all: $(TARGET)

include common.mk

.PHONY: tests

tests: $(OBJS)
	$(MAKE) -C tests

.PHONY: clean
clean: common-clean
	$(MAKE) -C tests clean
