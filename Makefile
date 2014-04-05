RM=rm -f
CXX=g++
LD=ld
CFLAGS=-c -Wall -MMD
LDFLAGS=

MAIN=main.cpp
SOURCES=csv_parser.hpp csv_parser.cpp data_struct.h enum.h perceptron.h perceptron.cpp $(MAIN)
OBJECTS=$(SOURCES:.cpp=.o)
	DEPS=$(OBJECTS:.o=.d)
	EXECUTABLE=perceptron.out

all: $(SOURCES) $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS)
	$(CXX) $(LDFLAGS) $(OBJECTS) -o $@

-include $(DEPS)

.cpp.o:
	$(CXX) $(CFLAGS) -MF $(patsubst %.o,%.d,$@) $< -o $@

clean:
	$(RM) $(OBJECTS) $(DEPS) $(EXECUTABLE)
