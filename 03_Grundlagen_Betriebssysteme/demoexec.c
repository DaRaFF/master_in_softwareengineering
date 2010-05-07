/* Nach: An Introductory 4.3BSD IPC Tutorial, S. Sechrest */

#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdio.h>
#include <stdlib.h>

int main ()
{
  pid_t pid;
  int status;

  if (fork() == 0) {
    printf ("Child executing \"/bin/date\"\n");
    execl ("/bin/date", "date", 0);
    printf ("This should not happen!\n");
  }
  printf ("Parent waiting for child's death\n");
  pid=wait (&status);
  printf ("Parent: Child just died.\n");
  exit(0);
}
