/* Fork-Demo                    */

#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

void warten()
{ /* "Rechenzeit verbrauchen" */
  int i; float x;

  for (i=0;i<80000000;i++) {
    x+=92.77/29388;
  }
}


int main()
{
  pid_t k, pid;
  int p, status, q;

  k = fork();
  if (k != 0) { /* falls <> 0 --> THEN Elter */
    /* Elter mit k= Prozessnummer des Kindes */
    for (p=0; p<20; p++) {
      printf("\t\t\tElternteil %d, Kind=%d\n",p,k);
      warten();
    }
    pid=wait(&status);
    printf("\t\t\tIst Kindprozess beendet? PID war, %d\n",pid);
    while(1); /* auf  Abbruch durch <CTRL/C> warten */
  }
  else { /* Kind mit k=0 */
    printf("Kindprozessnummer= %d \n", getpid());
    for (p=0; p<10; p++) {
      printf ("Kind %d,%d\n",p,k);
      warten();
    }
    exit(1);
  }
}
