//==============================================================================
//        * Letsch Informatik *       www.LetsInfo.ch       CH-8636 Wald
//          Beratung, Ausbildung und Realisation in Software-Engineering
//==============================================================================
// Project   : Master of Advanced Studies in Software-Engineering MAS-SE 2010
// Modul     : C++
// Title     : Übung "Klasse Person": Lösung
// Author    : Thomas Letsch
// Tab-Width : 2
/*///===========================================================================
* Description: Klasse implementieren und erweitern aufgrund applikatorischer
*              Anforderungen.
* History    : 11.01.04: Initial Version.
*              29.10.05: Anpassung wegen Eclipse/CDT-Bug
*                        (siehe Bugzilla Bug #102043)
*              01.10.07: Anpassung wegen Eclipse/CDT-Bug wieder entfernt.
*              02.11.08: Merge für MAS.
*              19.09.10: inline -> Optimierung
* Version    : $Revision: 1.13 $  $Date: 2010/09/19 15:36:33 $
/*///===========================================================================
//       1         2         3         4         5         6         7         8
//345678901234567890123456789012345678901234567890123456789012345678901234567890
//==============================================================================

#include <iostream>
#include <cstring>
#include "Person.h"
#include "StatisticStopWatch.h"

using namespace std;

void aufgabe1();
void aufgabe2();
void aufgabe4();

int main(int argc, char* argv[]) {

  if ((argc == 2) && (strcmp(argv[1], "OnlyStackVsHeap") == 0)) {
    aufgabe2();
  }
  else {
    aufgabe1();
    aufgabe2();
    aufgabe4();
  }
  return 0;

}


void aufgabe1() {
  // Klasse, Strings, char-Array, Arrays von Objekten:
  cout << endl << "Aufgabe 1:" << endl;

  const int MAX_ARR = 5;

  Person persArr[MAX_ARR];
  cout << endl << "Personen-Array:" << endl;
  for (int i = 0; i < MAX_ARR; i++) {
    cout << persArr[i].getNr() << ": " << persArr[i].getName() << endl;
  }
  persArr[0].setName("Miller");
  persArr[0].setNr(1);
  persArr[1].setName("Bond");
  persArr[1].setNr(007);
  cout << endl << "Personen-Array:" << endl;
  for (int i = 0; i < MAX_ARR; i++) {
    cout << persArr[i].getNr() << ": " << persArr[i].getName() << endl;
  }

  // Ausgabe des Personen-Arrays wie oben mit for-Schleifen, jetzt aber mit
  // Funktion 'printPersArr()':
  cout << endl << "Personen-Array mit \'printPersArr()\':" << endl;
  printPersArr(persArr, MAX_ARR);
}


void aufgabe2() {
  // Untersuchung wieviel Zeit Objekt-Allozierungen auf Stack und Heap benoetigen:
  cout << endl << "Aufgabe 2: Stack vs. Heap:" << endl;

  StatisticStopWatch stopWatch;
  const int MAX_LOOP = 10000000;

  // Allozierung auf dem Stack:
  stopWatch.reset();
  stopWatch.start();
  for (int i = 0; i < MAX_LOOP; i++) {
    Person pers(i, "John");
  }
  stopWatch.stop();
  stopWatch.printTime("Stack");

  // Allozierung auf dem Heap:
  stopWatch.reset();
  stopWatch.start();
  for (int i = 0; i < MAX_LOOP; i++) {
    Person* pers = new Person(i, "John");
  }
  stopWatch.stop();
  stopWatch.printTime("Heap: new()");
}


void aufgabe4() {
  // Links-Shift-Operator (<<) und 'const':
  cout << endl << "Aufgabe 4:" << endl;

  Person tom(1, "Tom");
  Person john = "John Smith";
  cout << tom << john;

  const Person bond(4711, "James Bond");
  cout << bond;
  cout << bond.getNr();
}


/* Session-Log:

$ make clean all
rm -f Person.o PersonTest.o StatisticStopWatch.o appl.exe
g++ -g -O0 -c Person.cpp
g++ -g -O0 -c PersonTest.cpp
g++ -g -O0 -c StatisticStopWatch.cpp
g++ -g -O0 -o appl.exe Person.o PersonTest.o StatisticStopWatch.o

$ ./appl.exe

Aufgabe 1:

Personen-Array:
-1:
-1:
-1:
-1:
-1:

Personen-Array:
1: Miller
7: Bond
-1:
-1:
-1:

Personen-Array mit 'printPersArr()':
1: Miller
7: Bond
-1:
-1:
-1:

Aufgabe 2: Stack vs. Heap:
Stack                =        250 ms
Heap: new()          =       2040 ms

Aufgabe 4:
Name: Tom                   Nr: 1
Name: John Smith            Nr: -1
Name: James Bond            Nr: 4711
4711
$


# Aufgabe 3:

$ for i in O0 O1 O2 O3
> do
>   echo ""
>   echo "Optimization $i:"
>   g++ -$i -o appl.exe Person.cpp PersonTest.cpp StatisticStopWatch.cpp
>   ./appl.exe OnlyStackVsHeap
> done

Optimization-Level: O0 :

Aufgabe 2: Stack vs. Heap:
Stack                =        256 ms
Heap: new()          =       2031 ms

Optimization-Level: O1 :

Aufgabe 2: Stack vs. Heap:
Stack                =        220 ms
Heap: new()          =       2015 ms

Optimization-Level: O2 :

Aufgabe 2: Stack vs. Heap:
Stack                =        188 ms
Heap: new()          =       1937 ms

Optimization-Level: O3 :

Aufgabe 2: Stack vs. Heap:
Stack                =        150 ms
Heap: new()          =       1920 ms

*/
