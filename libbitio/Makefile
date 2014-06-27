MAJOR_VERSION=0
MINOR_VERSION=1
VERSION=$(MAJOR_VERSION).$(MINOR_VERSION)

CXX=g++
CXXFLAGS=-Wall -O2
LD=g++
LDFLAGS=
AR=ar

ECHO=echo
RM=rm -rf
MAKEDEPEND=cpp -MM
SED=sed
LN=ln -s
FIND=find

VPATH=src

sources=bitwriter.cpp \
	bitreader.cpp \
	bitio_version.cpp

all: libbitio.so libbitio.a

libbitio.so: libbitio.so.$(VERSION)
	@$(ECHO) Creating shared library symlink && \
	$(LN) $(<) $(@)

libbitio.so.$(VERSION): $(sources:.cpp=.o)
	@$(ECHO) Creating shared library && \
	$(LD) $(LDFLAGS) -shared -Wl,-soname,libbitio.so.$(MAJOR_VERSION) -o libbitio.so.$(VERSION) $(^)

libbitio.a: $(sources:.cpp=.o)
	@$(ECHO) Creating static library && \
	$(AR) -crs $(@) $(^)

%.o: %.cpp
	@$(ECHO) Compiling $< && \
	$(CXX) $(CXXFLAGS) -DMAJOR_VERSION=$(MAJOR_VERSION) -DMINOR_VERSION=$(MINOR_VERSION) -DVERSION_STRING=\"$(VERSION)\" -fPIC -c $<

clean:
	@$(ECHO) Cleaning the project && \
	$(RM) libbitio.so libbitio.so.$(VERSION) libbitio.a && \
	$(FIND) . -name '*.o' -exec $(RM) '{}' ';' && \
	$(FIND) . -name '*.d' -exec $(RM) '{}' ';' && \
	$(FIND) . -name '*~'  -exec $(RM) '{}' ';'


%.d: %.cpp
	@$(ECHO) Generating dependencies for $< && \
	$(RM) $@ && \
	$(MAKEDEPEND) $< > $@.$$$$ && \
	$(SED) 's,\($*\)\.o[ :]*,\1.o $@ : ,g' < $@.$$$$ > $@ && \
	$(RM) $@.$$$$

-include $(sources:.cpp=.d)
