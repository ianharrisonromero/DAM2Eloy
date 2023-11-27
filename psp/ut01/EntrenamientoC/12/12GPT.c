#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <stdbool.h>
#include <math.h>

bool esPrimo(int n) {
    if (n <= 1) {
        return false;
    }
    for (int i = 2; i <= sqrt(n); i++) {
        if (n % i == 0) {
            return false;
        }
    }
    return true;
}

int main(int argc, char const *argv[]) {
    if (argc != 3) {
        printf("Número de argumentos inválido\n");
        return 1;
    }

    int longitud = atoi(argv[1]);
    int n_procesos = atoi(argv[2]);
    int i = 0;
    pid_t hijo;

    // Calcular el rango de números primos que cada proceso debe verificar
    int inicio = 2 + (longitud / n_procesos) * i;
    int fin = 2 + (longitud / n_procesos) * (i + 1);

    for (i; i < n_procesos; i++) {
        hijo = fork();

        if (hijo == 0) {
            // Código ejecutado por cada hijo
            for (int j = inicio; j < fin; j++) {
                if (esPrimo(j)) {
                    printf("Nuevo primo encontrado por el proceso %d: %d\n", i, j);
                }
            }
            // Salir después de terminar el trabajo
            exit(0);
        } else if (hijo > 0) {
            // Código ejecutado por el padre
            // Esperar a que el hijo termine
            wait(NULL);
        } else {
            // Manejar errores en la creación de procesos
            perror("fork");
            return 1;
        }
    }

    return 0;
}
