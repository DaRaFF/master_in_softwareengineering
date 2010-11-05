#ifndef PERSON_H
#define PERSON_H 1

#include <cstring>
#include <iostream>

using std::ostream;


// Klassen-Definition:

// Person:
// Eine Person hat einen Namen (20 Char's) und eine Nummer.

const int NAME_LEN = 20;

class Person {

  enum {NAME_LEN = 20};  // andere Variante:
                         // G�ltigkeitsbereich auf Klasse beschraenkt.


  friend ostream& operator<<(ostream& pOS, const Person& pPerson);

  public:
                  Person(const char* pName = 0);
                  Person(int pNr, const char* pName);
    int           getNr() const;
    const char*   getName() const;
    void          setNr(int pNr);
    void          setName(const char* pName);

  private:
    int   mNr;
    char  mName[NAME_LEN+1];

};


// Funktions-Prototypen:

// Ausgabe eines Arrays von Personen-Objekten auf die Konsole.
//   pPers: Pointer auf erstes Personen-Objekt im Array.
//   pLen:  Laenge des Personen-Arrays.
void printPersArr(Person* pPers, int pLen);


#endif /*PERSON_H*/
