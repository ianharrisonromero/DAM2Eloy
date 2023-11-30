// Uso de valores de retorno : Modifica el programa para que cada proceso hijo
// devuelva un valor de salida diferente utilizando exit().El proceso padre debe
// recoger estos valores de salida utilizando wait() o waitpid() y mostrarlos en su salida.

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

void signal_handler(int signo)
{
    switch (signo)
    {
    case 0:
        printf("He recibido la señal %d, voy a salir con código 0 (EXIT_SUCCESS)\n", signo);
        exit(EXIT_SUCCESS);
        break;
    case 1:
        printf("He recibido la señal %d, voy a salir con código 0 (EXIT_SUCCESS)\n", signo);
        exit(EXIT_SUCCESS);
        break;
    case 2:
        printf("He recibido la señal %d, voy a salir con código 0 (EXIT_SUCCESS)\n", signo);
        exit(EXIT_SUCCESS);
        break;
    case 3:
        printf("He recibido la señal %d, voy a salir con código 0 (EXIT_SUCCESS)\n", signo);
        exit(EXIT_SUCCESS);
        break;
    case 4:
        printf("He recibido la señal %d, voy a salir con código 0 (EXIT_SUCCESS)\n", signo);
        exit(EXIT_SUCCESS);
        break;
    case 5:
        printf("He recibido la señal %d, voy a salir con código 0 (EXIT_SUCCESS)\n", signo);
        exit(EXIT_SUCCESS);
        break;
    default:
        printf("He recibido una señal muy alta, voy a salir con código 1 (EXIT_FAILURE)\n");
        exit(EXIT_FAILURE);
        break;
    }
}

int main(int argc, char const *argv[])
{

    if (argc != 2)
    {
        printf("Numero o formato de parametros invalido\n");
    }

    int const N_HIJOS = atoi(argv[1]);
    int status;
    pid_t hijo;
    int j;

    for (j = 0; j < N_HIJOS; j++) // j en vez de i porque el autocompletador lo pone a i (me puede servir luego)
    {
        hijo = fork();

        if (hijo == 0)
        {
            break;
        }
    }

    for (int i = 0; i < N_HIJOS; i++)
    {
        if (j == i)
        {
            if (j == (N_HIJOS - 1))
            {
                printf("Soy el último proceso (%d), voy a salir con retorno 1\n", j);
                exit(EXIT_FAILURE);
            }

            printf("Soy el proceso %d, voy a salir con retorno 0\n", j);
            exit(EXIT_SUCCESS);
        }
    }

    if (hijo != 0)
    {
        sleep(5);

        for (int i = 0; i < N_HIJOS; i++)
        {
            wait(&status);

            int exit_status = WEXITSTATUS(status);

            switch (exit_status)
            {
            case EXIT_SUCCESS:
                printf("Soy el padre, TODO BIEN, he recibido el status : EXIT_SUCCESS\n");
                break;
            case EXIT_FAILURE:
                printf("Soy el padre, HAY FALLOS, he recibido el status : EXIT_FAILURE\n");
                break;

            default:
                printf("Soy el padre, error al recibir el status de hijos\n");
                break;
            }
        }
    }

    return 0;
}
