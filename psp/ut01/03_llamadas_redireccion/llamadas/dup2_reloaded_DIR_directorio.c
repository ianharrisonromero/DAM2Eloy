#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <dirent.h>

int main()
{
    // Abre o crea un archivo para escribir el contenido del directorio
    int fileDescriptor = open("listado_directorio.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);

    if (fileDescriptor == -1)
    {
        perror("Error al abrir o crear el archivo");
        return 1;
    }

    // Redirige la salida estándar (STDOUT_FILENO) al descriptor del archivo
    if (dup2(fileDescriptor, STDOUT_FILENO) == -1)
    {
        perror("Error al redirigir la salida estándar");
        close(fileDescriptor);
        return 1;
    }

    // Cierra el descriptor del archivo original (STDOUT_FILENO ya no lo necesita)
    close(fileDescriptor);

    // Abre el directorio
    DIR *directory = opendir("/");

    if (directory == NULL)
    {
        perror("Error al abrir el directorio");
        return 1;
    }

    // Lee y escribe el contenido del directorio
    struct dirent *entry;
    while ((entry = readdir(directory)) != NULL)
    {
        printf("%s\n", entry->d_name);
    }

    // Cierra el directorio
    closedir(directory);

    return 0;
}
