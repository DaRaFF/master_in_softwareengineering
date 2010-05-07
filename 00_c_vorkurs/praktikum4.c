#include <stdio.h>
#include <math.h>
#include <ctype.h>

//A39
int printBin(int number){
	int i;
	int anzBit = sizeof(number)*8;
	int bitValue;
	unsigned int maske = 1 << ((sizeof(number)*8)-1);

	for(i = 0; i<anzBit; i++){
		bitValue = maske & number;
		if(bitValue == 0){
			printf("0");
		}
		else{
			printf("1");
		}
		maske = maske >> 1;
	}
	printf("\n");
	return 0;
}

//A40
int invertNumber2Times(int number){
	number = ~(~number);
	printf("%i", number);
}

//A41 manuell 23 = 00010111 dual
//	       4 = 00000100 dual
// x = 23 ^ 4    = 00010011 dual
// x = 23 ^ 4    = 19 dezimal
void echoExor(){
	printf("\nDie Operation 23 ^ 4 gibt %d\n", 23 ^ 4);
}

//A42
//Adresse Zeiger 101,108,104

//A43
void strToUpperCase(){
    char text[] = "Dies ist ein kleiner Test.";

    char * pc = text;

    printf("Der original String lautet: %s\n", text);

    while ((*pc)) {
        if ( islower ( *pc )) {
           *pc = toupper(*pc);
        }
        pc++;
    }
    printf("Der umgewandelte String lautet: %s\n", text);
}

//A44
//A45
//A46


//MAIN
int main() {
	printBin(4711);
	invertNumber2Times(3724);
	echoExor();
	strToUpperCase();
	return 0;
}
