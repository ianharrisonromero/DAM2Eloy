// 13Crea un programa que reciba por parámetro dos números grandes. El programa creará dos procesos hijos.
// Cada hijo gestionará un número y verificará si es primo o no. Cada hijo al finalizar indica
// en su estado si el número era primo o no y el proceso padre al recoger el estado del hijo cuenta
// si era primo o no, el padre escribe el total de números primos.

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
#define TOTAL_HIJOS 2

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
        printf("Número de argumentos inválido.\n");
    }

    int primero_recibido = atoi(argv[1]);
    int segundo_recibido = atoi(argv[2]);
    int resultadoHijo1;
    int resultadoHijo2;
    int contadorPrimos;
    int numero_de_hijo;

    for (numero_de_hijo = 0; numero_de_hijo < TOTAL_HIJOS; numero_de_hijo++)
    {
        pid_t hijo = fork();

        if (hijo == 0)
        {
            break;
        }
    }

    if (numero_de_hijo == 0)
    {
        printf("Hijo %d está calculando...\n", numero_de_hijo);
        if (esPrimo(primero_recibido))
        {
            exit(0);
        }
        else
        {
            exit(1);
        }
    }

    if (numero_de_hijo == 1)
    {
        printf("Hijo %d está calculando...\n", numero_de_hijo);
        if (esPrimo(segundo_recibido))
        {
            exit(0);
        }
        else
        {
            exit(1);
        }
    }

    

    // Meter en resultadoHijo el resultado del wait
    wait(&resultadoHijo1);
    wait(&resultadoHijo2);

    if (resultadoHijo1 == 0)
    {
        printf("El hijo 0 ha retornado %d, el número %d es primo\n", resultadoHijo1, primero_recibido);
    }
    else
    {
        printf("El hijo 0 ha retornado %d, el número %d no es primo\n", resultadoHijo1, primero_recibido);
    }

    if (resultadoHijo2 == 0)
    {
        printf("El hijo 1 ha retornado %d, el número %d es primo\n", resultadoHijo2, segundo_recibido);
    }
    else
    {
        printf("El hijo 1 ha retornado %d, el número %d no es primo\n", resultadoHijo2, segundo_recibido);
    }

    return 0;
}
