// Crea un proceso que cree dos procesos hijos, luego generará N (20) números aleatorios.
// Enviará los pares al primer hijo, los impares al segundo. Los hijos escribirán por pantalla
//"Soy el hijo 1|2, he recibido ". Por cada número que mande el padre.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#define N_HIJOS 2
#define N_RANDOMS 20
#define MAX_RANGE 100
#define MIN_RANGE 1



int main()
{

    int i = 0;
    pid_t hijo;
    int fd_evens[2];
    int fd_odds[2];
    pipe(fd_odds);
    pipe(fd_evens);
    int rand_num = 0;
    int even_counter = 0;
    int odd_counter = 0;

    for (i = 0; i < N_HIJOS; i++)
    {

        hijo = fork();

        if (hijo == 0)
        {
            break;
        }
    }

    if (hijo != 0)
    {
        // printf("Soy el PADRE y mi i multiplicada por 3 es %d\n", i * 3); // padre se queda con el número más alto (en este caso el 2)
        srand(time(NULL));
        close(fd_odds[0]);
        close(fd_evens[0]);
        for (int i = 0; i < N_RANDOMS; i++)
        {
            int rand_num = rand() % MAX_RANGE + MIN_RANGE;
            if (rand_num % 2 == 0)
            {
                write(fd_evens[1], &rand_num, sizeof(rand_num));
                even_counter++;
            }
            else
            {
                write(fd_odds[1], &rand_num, sizeof(rand_num));
                odd_counter++;
            }
        }
        close(fd_odds[1]);
        close(fd_evens[1]);
    }

    if (i == 0)
    {
        printf("\nSoy el hijo PAR, he recibido estos números : \n");
        close(fd_evens[1]);
        close(fd_odds[1]);
        close(fd_odds[0]);
        while (read(fd_evens[0], &rand_num, sizeof(20)) > 0 )
        {
            printf("%d ", rand_num);
        }
        close(fd_evens[0]);
    }

    if (i == 1)
    {
        close(fd_evens[0]);
        close(fd_evens[1]);
        close(fd_odds[1]);
        printf("\nSoy el hijo IMPAR, he recibido estos números : \n");

        while (read(fd_odds[0], &rand_num, sizeof(20)) > 0 )
        {
            printf("%d ", rand_num);
        }
        close(fd_odds[0]);
    }

    // printf("counters : %d , %d", even_counter, odd_counter);

    // printf(" mi i multiplicada por 3 es %d\n", i * 3); //los hijos se quedan con los primeros numeros de i al iterar por el for

    return 0;
}