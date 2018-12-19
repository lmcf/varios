#include <stdlib.h>
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

void main()
{
	pid_t fill;
	fill = fork();

	if (fill == -1) //Error
	{
		printf ("No se ha podido crear el proceso hijo");
		exit (-1);
	}
	if (fill == 0) //Proceso Hijo
	{
		printf("Soy el proceso hijo \n\t Mi PID es %d, El PID de mi padre es %d. \n",getpid(), getppid());
	}
	else
	{
		fill = wait(NULL);
		printf("Soy el proceso padre:\n\t Mi PID es %d,  Mi hijo: %d termino. \n ",getpid(),fill);
	}
	exit(0);
}