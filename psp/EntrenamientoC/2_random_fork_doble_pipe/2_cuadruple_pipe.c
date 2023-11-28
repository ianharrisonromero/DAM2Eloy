#include <stdio.h>      // Manejo de entrada/salida estándar
#include <stdlib.h>     // Funciones de utilidad general
#include <string.h>     // Funciones de manipulación de cadenas de caracteres
#include <ctype.h>      // Funciones para clasificación y manipulación de caracteres
#include <math.h>       // Funciones matemáticas
#include <time.h>       // Funciones para trabajar con el tiempo
#include <limits.h>     // Constantes de límites de tipos de datos
#include <stdbool.h>    // Definiciones para valores booleanos
#include <stddef.h>     // Definiciones estándar
#include <stdint.h>     // Tipos de datos enteros con anchos específicos
#include <stdarg.h>     // Manipulación de argumentos variables
#include <assert.h>     // Macros para aserciones
#include <errno.h>      // Definiciones para códigos de error
#include <fcntl.h>      // Control de archivos
#include <signal.h>     // Manejo de señales
#include <unistd.h>     // Funciones para el sistema operativo POSIX
#include <wchar.h>      // Funciones y macros para manipular caracteres anchos
#include <locale.h>     // Manejo de configuraciones locales
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

// Crea un proceso que cree dos procesos hijos, luego generará N (20) números aleatorios.
// Enviará los pares al primer hijo, los impares al segundo. Los hijos escribirán por pantalla
//"Soy el hijo 1|2, he recibido ". Por cada número que mande el padre.

#define NUM_HIJOS 2
#define READ 0
#define WRITE 1
#define N_ALEATORIOS 20
#define MAX_RANGE 1000
#define MIN_RANGE 1

bool esPar(int n)
{
    if (n % 2 == 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}

int main(int argc, char const *argv[])
{
    srand(time(NULL));
    int nuevo_aleatorio;
    int nuevo_par;
    int nuevo_impar;
    int i;
    pid_t hijo;
    int fd_pares[2];
    int fd_impares[2];
    int fd_extra_pares[2];
    int fd_extra_impares[2];
    pipe(fd_pares);
    pipe(fd_impares);
    pipe(fd_extra_pares);
    pipe(fd_extra_impares);
    int suma_pares = 0;
    int suma_impares = 0;
    int resultado_pares;
    int resultado_impares;

    for (i = 0; i < NUM_HIJOS; i++)
    {
        hijo = fork();

        if (hijo == 0)
        {
            break;
        }
    }

    // CODIGO DEL PADRE
    if (hijo != 0) // padre genera aleatorios y manda a hijos
    {
        close(fd_pares[READ]); // cerramos todos los READ
        close(fd_impares[READ]);
        // close(fd_extra_pares[READ]); //estos lo mismo no NO SEEE
        // close(fd_extra_impares[READ]);
        close(fd_extra_pares[WRITE]);
        close(fd_extra_impares[WRITE]);

        for (int x = 0; x < N_ALEATORIOS; x++)
        {
            nuevo_aleatorio = rand() % (MAX_RANGE - MIN_RANGE) + MIN_RANGE;

            if (esPar(nuevo_aleatorio))
            {
                write(fd_pares[WRITE], &nuevo_aleatorio, sizeof(nuevo_aleatorio));
            }
            else
            {
                write(fd_impares[WRITE], &nuevo_aleatorio, sizeof(nuevo_aleatorio));
            }
        }

        close(fd_pares[WRITE]);
        close(fd_impares[WRITE]);

        for (int j = 0; j < NUM_HIJOS; j++)
        {
            wait(NULL);
        }
    }

    // CODIGOO hijo par

    if (i == 0)
    {
        close(fd_impares[READ]); // leemos pares
        close(fd_impares[WRITE]);
        close(fd_pares[WRITE]);
        close(fd_extra_impares[WRITE]);
        close(fd_extra_impares[READ]);
        close(fd_extra_pares[READ]);

        while (read(fd_pares[READ], &nuevo_par, sizeof(nuevo_par)) > 0)
        {
            printf("El hijo %d ha recibido el n par : %d\n", i, nuevo_par);
            suma_pares += nuevo_par;
        }

        close(fd_pares[READ]);

        write(fd_extra_pares[WRITE], &suma_pares, sizeof(suma_pares));

        close(fd_extra_pares[WRITE]);
    }

    // BLOQUE HIJO IMPAR
    if (i == 1)
    {
        // leemos impares
        close(fd_impares[WRITE]);
        close(fd_pares[WRITE]);
        close(fd_pares[READ]);
        close(fd_extra_pares[READ]);
        close(fd_extra_pares[WRITE]);
        close(fd_extra_impares[READ]);

        while (read(fd_impares[READ], &nuevo_impar, sizeof(nuevo_impar)) > 0)
        {
            printf("El hijo %d ha recibido el n impar : %d\n", i, nuevo_impar);
            suma_impares += nuevo_impar;
        }

        close(fd_impares[READ]);

        write(fd_extra_impares[WRITE], &suma_impares, sizeof(suma_impares));

        close(fd_extra_impares[WRITE]);
    }

    if (hijo != 0)
    {
        read(fd_extra_pares[READ], &suma_pares, sizeof(suma_pares));
        printf("Soy el padre, la suma de los n pares es : %d\n", suma_pares);
        close(fd_extra_pares[READ]);

        read(fd_extra_impares[READ], &suma_impares, sizeof(suma_impares));
        printf("Soy el padre, la suma de los n impares es : %d\n", suma_impares);
        close(fd_extra_impares[READ]);
    }

    return 0;
}
