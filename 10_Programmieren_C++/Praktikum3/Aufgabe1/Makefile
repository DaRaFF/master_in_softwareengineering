
# Makefile für Übung "Klasse Person"                           19.09.2010

BIN    = appl.exe
OBJS   = Person.o PersonTest.o StatisticStopWatch.o

CC     = g++
CFLAGS = -g -O0

all: $(BIN)

$(BIN): $(OBJS)
	$(CC) $(CFLAGS) -o $(BIN) $(OBJS)

clean:
	rm -f $(OBJS) $(BIN)

%.o: %.cpp %.h
	$(CC) $(CFLAGS) -c $<

%.o: %.cpp
	$(CC) $(CFLAGS) -c $<

