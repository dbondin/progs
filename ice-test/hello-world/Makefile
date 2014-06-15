SOURCES=server.cpp \
        client.cpp

ICE_JAR=/usr/share/java/Ice.jar

all: server client server-java.sh client-java.sh server-python.sh client-python.sh

Printer.cpp Printer.h: Printer.ice
	slice2cpp $<

%.o: %.cpp
	g++ -I. -c $<

server: server.o Printer.o
	g++ -o $@ $^ -lIce -lIceUtil

client: client.o Printer.o
	g++ -o $@ $^ -lIce -lIceUtil

clean:
	rm -rf \
	Printer.cpp \
	Printer.h \
	*.o \
	*.d \
	server \
	client \
	generated \
	PrinterI.class* \
	Server.class* \
	Client.class* \
	server-java.sh \
	client-java.sh \
	Printer_ice.py \
	server-python.sh \
	client-python.sh \
	Demo \
	*.pyc

%.d: %.cpp
	set -e; g++ -MM $< | sed 's/\($*\)\.o[ :]*/\1.o $@ : /g' > $@; [ -s $@ ] || rm -f $@

server.cpp: Printer.h

generated: Printer.ice
	mkdir $@
	slice2java --output-dir $@ $<

PrinterI.java: generated
Server.java: generated PrinterI.class
Client.java: generated PrinterI.class

server-java.sh: Server.class
	echo "#!/bin/bash" > $@
	echo "" >> $@
	echo "java -classpath $(ICE_JAR):generated:. Server" >> $@
	chmod 755 $@

client-java.sh: Client.class
	echo "#!/bin/bash" > $@
	echo "" >> $@
	echo "java -classpath $(ICE_JAR):generated:. Client" >> $@
	chmod 755 $@

server-python.sh: Printer_ice.py
	echo "#!/bin/bash" > $@
	echo "" >> $@
	echo "python Server.py" >> $@
	chmod 755 $@

client-python.sh: Printer_ice.py
	echo "#!/bin/bash" > $@
	echo "" >> $@
	echo "python Client.py" >> $@
	chmod 755 $@

%.class: %.java
	javac -classpath $(ICE_JAR):generated:. $<

Printer_ice.py: Printer.ice
	slice2py $<

include $(SOURCES:.cpp=.d)
