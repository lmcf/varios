#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
int main()
{
	int fd[2];
	char buffer[30];
	pid_t pid;

	pipe(fd);	//se crea el pipe, devuelve 0 si exito y delvuelve -1 si error
	pid=fork();	//se crea el proceso hijo --> devuleve -1 si error, devuelve 0 si estamos en proceso hijo y devuelve el pid del hijo si estamos en el padre

	switch (pid) {

		case -1 :  //ERROR
			printf("No se ha podido crear el hijo...");
			exit(-1);
			break;

		case 0 :  //Hijo
			printf("El HIJO escribe en elpipe...\n");
			write(fd[1], "Hola, soy proceso hijo", 22);
			break;

		default :   //PADRE
			wait(NULL);    //Espera que finalice el proceso hijo, si no espera el padre empezará a escribir quedando oculta la ejecucion hasta q finalice el hijo
			printf("Elpadre lee del pipe...\n");
			read(fd[0], buffer, 22);
			printf("\t Mensaje leido: %s\n", buffer);
			break;
	}
}
