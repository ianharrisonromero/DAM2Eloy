#include <stdio.h>   // Manejo de entrada/salida estándar
#include <stdlib.h>  // Funciones de utilidad general
#include <string.h>  // Funciones de manipulación de cadenas de caracteres
#include <ctype.h>   // Funciones para clasificación y manipulación de caracteres
#include <math.h>    // Funciones matemáticas
#include <time.h>    // Funciones para trabajar con el tiempo
#include <limits.h>  // Constantes de límites de tipos de datos
#include <stdbool.h> // Definiciones para valores booleanos
#include <stddef.h>  // Definiciones estándar
#include <stdint.h>  // Tipos de datos enteros con anchos específicos
#include <stdarg.h>  // Manipulación de argumentos variables
#include <assert.h>  // Macros para aserciones
#include <errno.h>   // Definiciones para códigos de error
#include <fcntl.h>   // Control de archivos
#include <signal.h>  // Manejo de señales
#include <unistd.h>  // Funciones para el sistema operativo POSIX
#include <wchar.h>   // Funciones y macros para manipular caracteres anchos
#include <locale.h>  // Manejo de configuraciones locales
#include <sys/types.h>  // Definiciones de tipos de datos utilizados en llamadas al sistema
#include <sys/stat.h>   // Definiciones de estructuras para la información del estado de los archivos
#include <dirent.h>     // Estructuras y funciones para manipulación de directorios
#include <pthread.h>    // Funciones y tipos de datos para programación multihilo
#include <semaphore.h>  // Funciones y tipos de datos para semáforos
#include <netinet/in.h> // Definiciones de estructuras para direcciones de red
#include <arpa/inet.h>  // Funciones para manipular direcciones IP
#include <sys/socket.h> // Funciones y estructuras para programación de sockets
#include <sys/time.h>   // Estructuras y funciones para manejo del tiempo y temporizadores
#include <sys/wait.h>   // Funciones para el manejo de procesos hijo


int main(int argc, char const *argv[])
{
    if (argc != 2)
    {
        printf("número de parámetros inválido");
    }

    int num_hijos = atoi(argv[1]);
    pid_t hijo;
    int i;

    for (hijo = 0; hijo < num_hijos; hijo++)
    {
        hijo = fork();

        if (hijo == 0)
        {
            break;
        }
    }

    if (hijo != 0)
    {
        printf("Hola, soy el padre (%d)\n", hijo);
    }

    for (i = 0; i < num_hijos; i++)
    {

        if (hijo == 0)
        {
            printf("Hola, soy el hijo %d\n", i);
        }
    }

    if (hijo != 0)
    {
        printf("Soy el padre, mi numero i es %d\n", i);
    }

    return 0;
}
