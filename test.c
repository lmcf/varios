#include <stdio.h>
#include <stdlib.h>
void main()
{
	printf("Ejemplo de uso de system()");
	printf("\n\tListado del directorio actual y envio a un fichero");
	printf("%d",system("ls > ficsalidas"));
	printf("\n\tAbrimos con el gedit el fichero...");
	printf("%d",system("subl ficsalida"));
	printf("\n\tEste comando es erroneo: %d",system("ged"));
	printf("\nFin de programa.....\n");
}