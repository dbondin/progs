CXX=g++
CXXFLAGS=-Wall -O0 -g
CPPFLAGS=

LD=g++
LDFLAGS=

RMRF=rm -rf
ECHO=echo
SED=sed
MAKEDEPEND=cpp -MM

SRC=$(wildcard *.cpp)
TARGET=target

all: $(TARGET)

$(TARGET): $(SRC:.cpp=.o)
	@$(ECHO) Linking $(@)
	@$(LD) $(LDFLAGS) -o $(@) $(^)
	
%.o: %.cpp
	@$(ECHO) Compiling $(<)
	@$(CXX) $(CPPFLAGS) $(CXXFLAGS) -c -o $(@) $(<)

%.d: %.cpp
	@$(ECHO) Generating dependencies for $< && \
	$(RMRF) $@ && \
	$(MAKEDEPEND) $< > $@.$$$$ && \
	$(SED) 's,\($*\)\.o[ :]*,\1.o $@ : ,g' < $@.$$$$ > $@ && \
	$(RM) $@.$$$$

clean:
	@$(RMRF) $(SRC:.cpp=.o) $(TARGET) $(SRC:.cpp=.d)

-include $(SRC:.cpp=.d)