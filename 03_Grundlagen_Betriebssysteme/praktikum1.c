#include <stdio.h>
#include <stdlib.h>

//forward declaration -> ist das so korrekt? sonst motzt der kompiler
int putenv(char *string);


extern char **environ;

int blubb = 23;
int *pBlubb = &blubb;


//E1.1
void argPrinter(int argc, char **argv){
	printf("\n\n Aufgabe E1.1\n");
  	printf("Anzahl Argumente: %d\n", argc-1);
	for(int i = 1; i < argc;i++){
		printf("Argument %d = %s\n", i, argv[i]);
	}
}

//E1.2a
void envPrinter(){
	printf("\n\n Aufgabe E1.2a\n");
	int i=0;
	while(environ[i] != NULL){
		printf("Environment %d = %s\n", i, environ[i]);
		i++;
	}
}

//E1.2b
void setAndgetAnEnvironmentVariable(){
	printf("\n\n Aufgabe E1.2b\n");
	char *putName = "EU=Europa";
	char *getName = "EU";
	char *value;
  	if (putenv(putName) != 0) {
    		perror ("Fehler bei putenv()");
    		exit(-1);
  	}
	value = getenv(getName);
	if(value != NULL){
		printf("Der Wert von der Env Variable EU ist = %s\n", value);
	}
	else{
		printf("Der Wert von der Env Variable EU wurde nicht korrekt gesetzt\n");	
	}
}



int main(int argc, char **argv){
	argPrinter(argc, argv);
	envPrinter();
	printf("Ein Wert aus einer PointerVariable: %d", *pBlubb);
	setAndgetAnEnvironmentVariable();	
  	return 0;
}
