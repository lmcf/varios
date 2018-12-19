#include <stdlib.h>
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

void main()
{
	pid_t padre,hijo,nieto;
	padre = fork();

	if (padre == -1) // No se ha podido crear el proceso hijo de padre
	{
		printf ("No se ha podido crear el proceso hijo\n");
        exit(-1);
	}
	else if (padre == 0) // Proceso hijo de padre
	{
		hijo = fork();
		if(hijo == -1) // No se ha podido crear el nieto de padre
		{
			printf ("No se ha podido crear el proceso hijo\n");
       		exit(-1);
		}
		else if (hijo == 0) // proceso nieto de padre
		{
			printf("Soy el proceso nieto: %d, Mi padre es %d\n",getpid(),getppid());
		}
		else // no hay creados salta hijo
		{
			nieto = wait(NULL);
			printf ("Soy el proceso hijo: %d, Mi padre es %d\n",getpid(),getppid());
		}
		
	}
	else //No hay creados salta padre
	{
		hijo = wait(NULL);
		printf("Soy el proceso padre: %d, Mi Hijo %d termino\n",getpid(),hijo);
	}
	exit(0);
}