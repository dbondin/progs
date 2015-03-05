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

VPATH=src

sources=huf_stat.cpp

all: huf_stat

huf_stat: $(sources:.cpp=.o)
	$(LD) -o $(@) $(^)
	
%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $<

clean:
	$(RM) huf_stat
	$(RM) $(sources:.cpp=.o)
	$(RM) $(sources:.cpp=.d)

%.d: %.cpp
	$(RM) $@ && \
	$(MAKEDEPEND) $< > $@.$$$$ && \
	$(SED) 's,\($*\)\.o[ :]*,\1.o $@ : ,g' < $@.$$$$ > $@ && \
	$(RM) $@.$$$$
