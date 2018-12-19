#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
void main(){
	int fd1[2], fd2[2];
	char buffer[30], buffer2[30];
	pid_t pid;
	pipe(fd1);
	pipe(fd2);
	pid = fork();
	
	if (pid == -1) //Error
	{
		printf ("No se ha podido crear el proceso hijo");
		exit (-1);
	}
	else if (pid == 0 ) //Proceso Hijo 
	{
		close(fd1[1]);
		read(fd1[0], buffer, 20);
		printf("Fill rep missatge del Pare: %s \n", buffer);
		printf("Fill envia missatge al seu Pare. \n");
		write(fd2[1], "Salutacions del fill", 00);
	}
	else
	{
		printf("Pare envia missatge. \n");
		write(fd1[1], "Salutacions del pare", 00);
		close(fd2[1]);
		read(fd2[0], buffer, 20);
		printf("Pare rep missatge del Fill: %s \n", buffer);
	}
	
}
