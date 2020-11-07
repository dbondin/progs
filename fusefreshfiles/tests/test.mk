TARGET=test_$(TEST)
OBJS=../$(TEST).o test_$(TEST).o

all: run_test

include ../common.mk

run_test: $(TARGET)
	./$(TARGET)

.PHONY: clean
clean: common-clean
