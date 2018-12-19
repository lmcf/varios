#include <stdlib.h>
#include <stdio.h>
#include <sys/wait.h>
#include <unistd.h>

void main()
{
	// El Padre es el pid de este programa
	pid_t hijo1,hijo2,hijo3;
	hijo1 = fork(); // El hijo es el siguiente pid respecto al del padre (subproceso del padre)

	if (hijo1 == -1) //Error
	{
		printf ("No se ha podido crear el proceso hijo");
		exit (-1);
	}
	else if (hijo1 == 0 ) //Proceso Hijo 
	{
		printf("Soy el hijo 1: \n\t Mi PID es %d \n\t El PID de mi padre es %d. \n",getpid(), getppid());
		//getpid() dira el pid del proceso que estoy ahora
		//getppid() me dira el pid del padre del proceso en el que estoy
	}
	else
	{
		hijo1 = wait(NULL); // El padre espera a que acabe el hijo
		hijo2 = fork();
		if (hijo2 == -1) //Error
		{
			printf ("No se ha podido crear el proceso hijo");
			exit (-1);
		}
		else if (hijo2 == 0 ) //Proceso Hijo 
		{
			printf("Soy el hijo 2: \n\t Mi PID es %d \n\t El PID de mi padre es %d. \n",getpid(), getppid());
		}
		else
		{
			hijo2 = wait(NULL); // El padre espera a que acabe el hijo
			hijo3 = fork(); 
			if (hijo3 == -1) //Error
			{
				printf ("No se ha podido crear el proceso hijo");
				exit (-1);
			}
			else if (hijo3 == 0 ) //Proceso Hijo 
			{
				printf("Soy el hijo 3: \n\t Mi PID es %d \n\t El PID de mi padre es %d. \n",getpid(), getppid());
			}
			else
			{
				hijo3 = wait(NULL); // El padre espera a que acabe el hijo
				printf("Soy el proceso padre:\n\t Mi PID es %d \n",getpid());
				
			}
		}
		
	}
	exit(0);
}
