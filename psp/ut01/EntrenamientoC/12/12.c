// 12Crea un programa en c que reciba un número n y un número m.
// El programa escribirá todos los números primos de la longitud n, utilizando m procesos.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <signal.h>
#include <stdbool.h>
#include <math.h>

bool esPrimo(int n)
{
    bool es_primo = true;
    for (int i = 2; i <= sqrt(n); i++)
    {
        if (n % i == 0)
        {
            es_primo = false;
            break;
        }
    }
    return es_primo;
}

int main(int argc, char const *argv[])
{
    if (argc != 3)
    {
        printf("Número de argumentos inválido\n");
    }

    int longitud = atoi(argv[1]);
    int n_procesos = atoi(argv[2]);
    int i = 1;
    pid_t hijo;

    for (i; i < n_procesos; i++)
    {
        hijo = fork();

        if (hijo == 0)
        {
            break; // SALID HIJOS, SALIDDDDD
        }
        
    }

    for (int j = 1; j < longitud; j++)
    {
        if (j % n_procesos == i)
        {
            if (esPrimo(j))
            {
                printf("Nuevo primo encontrado por el proceso %d: %d\n", i, j);
            }
        }
    }

    return 0;
}
