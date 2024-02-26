#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <stdlib.h>

void signal_handler(int signo)
{
    switch (signo)
    {
    case 1:
        printf("Se ha recibido signo : %d\n", signo);
        break;
    case 2:
        printf("Se ha recibido signo : %d\n", signo);
        break;

    default:
        printf("No se reconoce el signo %d\n", signo);
        break;
    }
}

int main(void)
{

    pid_t hijo;

    hijo = fork();

    int signo;

    if (hijo != 0)
    {
        while (1)
        {
            sleep(1);
            printf("Envía una señal al hijo : \n");
            scanf("%d", &signo);
            kill(hijo, signo);
        }
    }
    else
    {
        for (int i = 0; i < 21; i++)
        {
            signal(i, signal_handler);
        }
        while (1)
        {
            sleep(1);
        }

        // signal(0, signal_handler);
        // signal(1, signal_handler);
    }

    return 0;
}