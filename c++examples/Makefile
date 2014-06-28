SRCDIR=src
OUTDIR=bin
TNAME=target
DIRS=$(wildcard $(SRCDIR)/example-*)
TARGETS=$(patsubst $(SRCDIR)/%,$(OUTDIR)/%,$(DIRS))

ECHO=echo
MKDIR=mkdir
RMRF=rm -rf

.PHONY: clean $(TARGETS)

all: $(OUTDIR) $(TARGETS)

$(OUTDIR):
	$(MKDIR) -p $(OUTDIR)

$(TARGETS):
	@$(ECHO) Building $(@)
	@$(MAKE) -s -C $(patsubst $(OUTDIR)/%,$(SRCDIR)/%,$(@)) -f ../../example.mk TARGET=../../$(@)

clean:
	@$(RMRF) $(OUTDIR)
	@for i in $(DIRS); \
	do \
	  $(MAKE) -s -C $${i} -f ../../example.mk clean || exit 1; \
	done
