#include <stdio.h>
#include <math.h>
#define BUF_SIZE 5

//A29
void increment(int * x) { *x = *x + 1; }

int print23(){
	int a=23;
	increment((int *)&a);
	printf("Die Zahl lautet: %d\n", a);
	
}

//A30
int printHowManyTimesImCalled(){
	static int a = 0;
	a++;
	printf("Ich bin schon : %i mal aufgerufen worden.\n", a);
	return 0;
}

//A31 ist easy (nicht gelöst)
//A32 ist easy (nicht gelöst)
//A33 in Praktikum mit Lehrer gelöst
//A34 separat gelöst (Ausgabe Precompiler)
//A35 ist easy (nicht gelöst)

//A36
#define square(x) (x)*(x)
void correctMistake(){
    double y = 3.0;
    printf("Das Quadrat von %.2f ist %.2f\n", y, square(y));
    printf("Das Quadrat von %.2f ist %.2f\n", y+1, square(y+1));
}

//A37 ist easy (nicht gelöst)

//A38 noch offen

//MAIN
int main() {
	print23();
	for(int i = 0; i < 5; i++){
		printHowManyTimesImCalled();
	}
	correctMistake();
	return 0;
}
