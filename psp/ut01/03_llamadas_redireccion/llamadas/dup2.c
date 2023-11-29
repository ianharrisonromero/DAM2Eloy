#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

/* int dup2(int oldfd, int newfd);
Aquí hay una explicación más detallada :

    oldfd : Este es el descriptor de archivo existente que se duplicará.Puede ser el descriptor
    de archivo de la entrada estándar(0),
    la salida estándar(1), o la salida de errores estándar(2), o cualquier otro descriptor
    de archivo abierto.

    newfd : Este es el descriptor de archivo al cual se desea duplicar oldfd.Si newfd ya está abierto,
    se cerrará antes de la duplicación.Si newfd es igual a oldfd, la función no hace nada y devuelve newfd. */

int main()
{
    // Abrir un archivo para escribir
    int file_descriptor = open("salida.txt", O_WRONLY | O_CREAT | O_TRUNC, 0666);

    if (file_descriptor == -1)
    {
        perror("open");
        exit(EXIT_FAILURE);
    }

    // Redirigir la salida estándar al archivo
    if (dup2(file_descriptor, STDOUT_FILENO) == -1)
    {
        perror("dup2");
        exit(EXIT_FAILURE);
    }

    // Cerrar el descriptor de archivo original
    close(file_descriptor);

    // Ahora, cualquier cosa que se imprima en la salida estándar se escribirá en "salida.txt"
    printf("Este mensaje se escribirá en 'salida.txt'\n");

    return 0;
}