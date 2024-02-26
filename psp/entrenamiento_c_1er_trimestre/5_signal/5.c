// 5 Crea un proceso que sea capaz de gestionar un señal definida por el usuario.
// Luego hará fork y el padre le enviará la señas al hijo. Al gestionar la señal el hijo escribirá
//  "Recibido y terminará el proceso."

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <signal.h>

void signal_handler(int my_signal)
{
    switch (my_signal)
    {
    case 1:
        printf(" Soy el hijo, he recibido un 1 ");
        break;
    case 3:
        printf(" Soy el hijo, he recibido un 3 WUJUUUUU ");
        break;
    case 8:
        printf(" He recibido un 8, muriendo...");
        sleep(1);
        exit(0);
    case 9:
        printf(" MUERTE POR NUEVE, muriendo...");
        sleep(1);
        exit(0);
    default:
        break;
    }
}

int main(int argc, char const *argv[])
{
    pid_t hijo = fork();
    int my_signal;

    if (hijo == 0)
    {
        printf("Soy el hijo con pid: %d, me quedo ejecutando...\n", getpid());
        signal(1, signal_handler);
        signal(3, signal_handler);
        signal(8, signal_handler);
        signal(9, signal_handler);

        while (1)
        {
            printf(".");
            fflush(stdout);
            sleep(1);
        }
    }
    else
    {
        sleep(2);
        while (1)
        {
            // printf("Soy el padre: introduce un número(señal) para el hijo:\n");
            scanf("%d", &my_signal);
            kill(hijo, my_signal);
        }
    }

    return 0;
}
