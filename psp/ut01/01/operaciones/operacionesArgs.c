#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
    if (argc != 4) {
        printf("Usage: %s <number1> <operation> <number2>\n", argv[0]);
        return 1;
    }

    int num1 = atoi(argv[1]);
    char operacion = argv[2][0];
    int num2 = atoi(argv[3]);
    int resultado;

    switch (operacion) {
        case '+':
            resultado = num1 + num2;
            break;
        case '-':
            resultado = num1 - num2;
            break;
        case '*':
            resultado = num1 * num2;
            break;
        case '/':
            if (num2 == 0) {
                printf("No se puede dividir entre 0.\n");
                return 1;
            } else {
                resultado = num1 / num2;
            }
            break;
        default:
            printf("Operación no válida: %c\n", operacion);
            return 1;
    }

    printf("El resultado de %d %c %d es %d\n", num1, operacion, num2, resultado);

    return 0;
}
