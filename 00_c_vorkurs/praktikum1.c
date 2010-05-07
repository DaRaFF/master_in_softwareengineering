#include <stdio.h>

int myThousand = 1000;
int radius = 5;

//A1
int printThousandIn3Versions(){
  printf("1000 in 3 Formaten: %d, %o, %x\n ", myThousand, myThousand, myThousand);
  return 0;
}

//A2
int calculateUmfang(int radius){
  float umfang = 2*3.14*radius;
  printf("Der Umfang von Radius %i ist %f\n", radius, umfang);
}

//A3
int printAndConvertToDecimal(){
  int octalNumber = 023;
  int hexNumber = 0xff;
  printf("Die Oktal Zahl %o ist in Dezimal %d\n", octalNumber, octalNumber);
  printf("Die Hex Zahl %x ist in Dezimal %d \n", hexNumber, hexNumber);
}


//A4
int printNumbersAsChar(){
  printf("Aufgabe 4 ist nicht möglich\n");
}

//A5

//A6
int printMemoryUsageOfDataTypes(){
  printf("Anzahl Byte für char = %i\n", sizeof(char));
  printf("Anzahl Byte für char = %i || short = %i || int = %i || long = %i || longlong = %i \n", sizeof(char), sizeof(short), sizeof(int), sizeof(long), sizeof(long long));
}

//A7

//A8

//A9

//A10

//A11 - zu einfach

//A12

//A13
void userInput(){
	float userInput;
	printf("Bitte eine Fliesskommazahl eingeben: ");
	scanf("%f", &userInput);
	printf("Sie haben die zahl %f eingegeben\n", userInput);
}

//A14
void multiUserInput(){
	int mui1, mui2, mui3;
	printf("Bitte 3 Ganzzahlen eingeben: ");
	scanf("%d %d %d", &mui1, &mui2, &mui3);
	printf("Sie haben die zahlen %d, %d, %d eingegeben\n", mui1, mui2, mui3);
}

//A15 - scanf bricht bei einem Leerzeichen ab


int main(){
  	printThousandIn3Versions();
  	calculateUmfang(radius);
  	printAndConvertToDecimal();
  	printNumbersAsChar();
  	printMemoryUsageOfDataTypes();
	userInput();
	multiUserInput();
  return 0;
}
