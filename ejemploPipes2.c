#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
void main(void) {

	char saludo[] = "Un saludo!!!\n";
	char buffer[10];
	int fd, bytesleidos;

	fd = open("texto2.txt",1|100); //|100 sirve para si no esta creado lo crea y no da error
	//fichero que se abre solo para escritura
	
	if (fd == -1)
	{
		printf("ERROR AL ABRIR EL FICHERO......\n");
		exit(-1);
	}

	printf("Escribo el saludo...\n");
	write(fd, saludo, strlen(saludo)); 	
	close(fd);

	fd=open("texto2.txt",0);
	printf("Contenido del fichero: \n");

	bytesleidos= read(fd, buffer, 1);
	while (bytesleidos != 0){
		printf("%s", buffer);
		bytesleidos= read(fd, buffer, 1);
	}
	close(fd);
}	
