// En este bloque de código :

// Se abre el archivo "datos.txt" en modo de escritura de texto("w")
// .Se comprueba si la apertura fue exitosa y se escribe en el archivo dos líneas de texto.Se cierra el archivo después de escribir.Se reabre el archivo en modo de lectura de texto("r")
// .Se comprueba si la reapertura fue exitosa y se lee cada línea del archivo,
// mostrándola en la consola.Se cierra el archivo después de leer.El programa retorna 0 indicando una ejecución exitosa.

#include <stdio.h>
#define BUFFER_SIZE 100

    int main()
{
    // Abrir el archivo en modo escritura de texto
    FILE *archivo = fopen("datos.txt", "w");

    // Comprobar si se pudo abrir el archivo
    if (archivo == NULL)
    {
        perror("No se pudo abrir el archivo");
        return 1;
    }

    // Escribir líneas de texto en el archivo
    fprintf(archivo, "Hola, mundo!\n");
    fprintf(archivo, "Este es un archivo de texto.\n");

    // Cerrar el archivo
    fclose(archivo);

    // Abrir el archivo en modo lectura de texto
    archivo = fopen("datos.txt", "r");

    // Comprobar si se pudo abrir el archivo
    if (archivo == NULL)
    {
        perror("No se pudo abrir el archivo");
        return 1;
    }

    // Leer y mostrar las líneas de texto desde el archivo
    printf("Leyendo el archivo de texto:\n");
    char linea[BUFFER_SIZE];
    while (fgets(linea, sizeof(linea), archivo) != NULL)
    {
        printf("%s", linea);
    }

    // Cerrar el archivo
    fclose(archivo);

    return 0;
}
