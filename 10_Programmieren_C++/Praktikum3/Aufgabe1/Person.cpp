
#include "Person.h"
#include <iomanip>

using std::ostream;
using std::cout;
using std::endl;
using std::setw;
using std::left;

// Methoden-Implementationen:


Person::Person(const char* pName) : mNr(-1) {
  if (pName == 0) {
    mName[0] = '\0';  // Null-Byte als erstes Byte im Array.
  }
  else {
    setName(pName);
  }
}


Person::Person(int pNr, const char* pName) : mNr(pNr) {
  setName(pName);
}


int Person::getNr() const {
  return mNr;
}


const char* Person::getName() const {
  return mName;
}


void Person::setNr(int pNr) {
  mNr = pNr;
}


void Person::setName(const char* pName) {
  strcpy(mName, pName);
}



// Funktions-Implementationen:

void printPersArr(Person* pPers, int pLen) {
  for (int i = 0; i < pLen; i++) {
    cout << pPers->getNr() << ": " << pPers->getName() << endl;
    pPers++;  // pPers soll auf 'naechste' Person zeigen (-> Zeiger-Arithmetik)
  }
}


// Operator als globale Funktion:

ostream& operator<<(ostream& pOutputStream, const Person& pPerson) {
  pOutputStream <<  "Name: " << setw(Person::NAME_LEN) << left << pPerson.mName
                << "  Nr: " << pPerson.mNr << "\n";
  return pOutputStream;
}
