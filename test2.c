#include <stdio.h>
#include <stdlib.h>
void main()
{
	printf ("Ejemplo de uso de execl() :");
	printf ("La ejecusion produce: \n");
	execl("/bin/ls","ls","-l", (char *) NULL);
}