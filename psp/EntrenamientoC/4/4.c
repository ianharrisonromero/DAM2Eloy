// 4.Crea un programa que reciba un número n por parámetro. El programa creará n hijos 
//y les enviará una señal a cada uno de ellos para matarlos.


#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <signal.h>

int main(int argc, char const *argv[])
{
    if (argc != 2 || atoi(argv[1]) > 500)
    {
        printf("Parámetros inválidos\n");
        return 1;
    }

    int n_hijos = atoi(argv[1]);
    pid_t array_hijos[n_hijos];
    int i = 0;

    // Creación de procesos hijos
    for (i; i < n_hijos; i++)
    {
        array_hijos[i] = fork();

        if (array_hijos[i] == 0)
        {
            // Código ejecutado por cada hijo
            printf("Soy el hijo %d, y mi pid es: %d\n", i + 1, getpid());
            
            // Ciclo infinito para mantener al hijo en ejecución
            while (1)
            {
                sleep(1);
            }
        }
    }

    sleep(1);

    // Código ejecutado por el padre
    if (array_hijos[i - 1] != 0) // Se cambia a array_hijos[i - 1] para obtener el último hijo creado
    {
        printf("Soy el padre :\n");
        for (int j = 0; j < n_hijos; j++)
        {
            kill(array_hijos[j], 15); // Envia señal SIGTERM (15) para terminar a cada hijo
            printf("Proceso %d finalizado\n", array_hijos[j]);
        }
    }

    return 0;
}
