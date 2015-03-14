CXX=g++
CXXFLAGS=-Wall -O0 -g
LD=g++
LDFLAGS=

ECHO=echo
RM=rm -rf
MAKEDEPEND=cpp -MM
SED=sed
LN=ln -s
FIND=find

LIBBITIO_INC=../libbitio/include
LIBBITIO_LIB=../libbitio

VPATH=src

sources=huf_stat.cpp TreeNode.cpp TreeNodePtrComparator.cpp

all: huf_stat

huf_stat: $(sources:.cpp=.o)
	$(LD) $(LD_FLAGS) -L$(LIBBITIO_LIB) -o $(@) $(^) -lbitio
	
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -I$(LIBBITIO_INC) -c $<

clean:
	$(RM) huf_stat
	$(RM) $(sources:.cpp=.o)
	$(RM) $(sources:.cpp=.d)

%.d: %.cpp
	$(RM) $@ && \
	$(MAKEDEPEND) $< > $@.$$$$ && \
	$(SED) 's,\($*\)\.o[ :]*,\1.o $@ : ,g' < $@.$$$$ > $@ && \
	$(RM) $@.$$$$
