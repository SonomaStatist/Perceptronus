RM=rm -f
CXX=g++
LD=ld
CFLAGS=-c -DDEBUG -g -Wall -MMD
LDFLAGS=

MAIN=main.cpp
SOURCES=csv_parser.cpp perceptron.cpp $(MAIN)
HEADERS=csv_parser.hpp data_struct.h enum.h perceptron.h
OBJECTS=$(SOURCES:.cpp=.o)
	DEPS=$(OBJECTS:.o=.d)
	EXECUTABLE=perceptron.out

all: $(SOURCES) $(HEADERS) $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS)
	$(CXX) $(LDFLAGS) $(OBJECTS) -o $@

-include $(DEPS)

.cpp.o:
	$(CXX) $(CFLAGS) -MF $(patsubst %.o,%.d,$@) $< -o $@

clean:
	$(RM) $(OBJECTS) $(DEPS) $(EXECUTABLE)

