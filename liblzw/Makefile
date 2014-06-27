CXX=g++
#CXXFLAGS=-Wall -g -DLZWDEBUG
CXXFLAGS=-Wall -O2
LD=g++
LDFLAGS=
AR=ar
#FPIC=-fPIC
FPIC=

LIBBITIO_PATH=../libbitio
LIBBITIO_CPPFLAGS=-I$(LIBBITIO_PATH)/include
LIBBITIO_LDFLAGS=-L$(LIBBITIO_PATH) -lbitio

CXXFLAGS += $(LIBBITIO_CPPFLAGS)
LDFLAGS  += $(LIBBITIO_LDFLAGS)

ECHO=echo
RM=rm -rf
MAKEDEPEND=cpp -MM
SED=sed
LN=ln -s
FIND=find

VPATH=src

lib_sources=lzwEncode.cpp \
            lzwDecode.cpp \
            lzwTable.cpp \
            lzwTableDec.cpp \
            lzwTableEnc.cpp \
            lzwdebug.cpp

test_sources=lzwtest.cpp

.PHONY: all
all: liblzw.a lzwtest

liblzw.a: $(lib_sources:.cpp=.o)
	@$(ECHO) Creating static library && \
	$(AR) -crs $(@) $(^)

lzwtest: $(test_sources:.cpp=.o)
	@$(ECHO) Linking test program && \
	$(LD) -o $(@) $(test_sources:.cpp=.o)  -L. -llzw $(LDFLAGS)

lzwtest: liblzw.a

%.o: %.cpp
	@$(ECHO) Compiling $< && \
	$(CXX) $(CXXFLAGS) $(FPIC) -c $<

.PHONY: clean

clean:
	@$(ECHO) Cleaning the project && \
	$(RM) liblzw.a lzwtest && \
	$(RM) $(lib_sources:.cpp=.o) && \
	$(RM) $(test_sources:.cpp=.o) && \
	$(RM) $(lib_sources:.cpp=.d) && \
	$(RM) $(test_sources:.cpp=.d)

%.d: %.cpp
	@$(ECHO) Generating dependencies for $< && \
	$(RM) $@ && \
	$(MAKEDEPEND) $< > $@.$$$$ && \
	$(SED) 's,\($*\)\.o[ :]*,\1.o $@ : ,g' < $@.$$$$ > $@ && \
	$(RM) $@.$$$$

ifneq ($(MAKECMDGOALS),clean)
-include $(lib_sources:.cpp=.d)
-include $(test_sources:.cpp=.d)
endif
