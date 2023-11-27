// 6Crea un programa que cree un hijo y le mande a través de un pipe un carácter y dos números.
// El carácter representa una operación matemática: suma o resta. El proceso hijo devolverá en su
// estado el resultado de la operación.

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

    int fd_numeros[2];
    int fd_operador[2];
    pipe(fd_numeros);
    pipe(fd_operador);
    int num1;
    int num2;
    char operador;
    char buffer_cleaner;
    

    pid_t hijo = fork();

    if (hijo != 0)
    {
        close(fd_numeros[0]);
        close(fd_operador[0]);

        printf("introduce el primer número (entero): ");
        scanf("%d", &num1);

        printf("introduce el primer número (entero): ");
        scanf("%d", &num2);

        write(fd_numeros[1], &num1, sizeof(num1));
        write(fd_numeros[1], &num2, sizeof(num2));
        // printf("num1 : %d num2 : %d", num1, num2);
        // fflush(stdin); // fflush NO FUNCIONA AAAAAAAHGHHDGH
        // fflush(stdout); // fflush   
        scanf("%c", &buffer_cleaner);

        printf("introduce el operador (+, -, *, /): ");
        scanf("%c", &operador);
        write(fd_operador[1], &operador, sizeof(operador));

        close(fd_numeros[1]);
        close(fd_operador[1]);
    }
    else
    {
        close(fd_numeros[1]);
        close(fd_operador[1]);
        read(fd_numeros[0], &num1, sizeof(num1));
        read(fd_numeros[0], &num2, sizeof(num2));
        read(fd_operador[0], &operador, sizeof(operador));

        switch (operador)
        {
        case '+':
            printf("El resultado de %d %c %d es : %d", num1, operador, num2, num1 + num2);
            break;
        case '-':
            printf("El resultado de %d %c %d es : %d", num1, operador, num2, num1 - num2);
            break;
        case '*':
            printf("El resultado de %d %c %d es : %d", num1, operador, num2, num1 * num2);
            break;
        case '/':
            if (num2 == 0)
            {
                printf("No se puede dividir entre 0");
                break;
            }
            else
            {
                printf("El resultado de %d %c %d es : %d\n", num1, operador, num2, num1 / num2);
                break;
            }

        default:
            printf("Hubo un problema en la operación");
            break;
        }

        close(fd_numeros[0]);
        close(fd_numeros[0]);
    }

    return 0;
}
