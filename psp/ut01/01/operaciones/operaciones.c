#include <stdio.h>          //libería para standard input/output
#include <unistd.h>         //llamadas del sistema unix
#include <sys/types.h>      //typos del sistema (necesario para poder usar pid)
#include <stdlib.h>
#include <string.h>


int main(void){
    
    long num1;
    long num2;
    char operacion;
    long resultado;


    printf("Ingrese el primer número de la operación: ");
    scanf("%ld" , &num1);
    printf("Ingrese el segundo número de la operación: ");
    scanf("%ld" , &num2);
    printf("Ingrese la operación que desea realizar ( + , - , * , / ): ");
    scanf(" %c" , &operacion);
    if (operacion == '/')
    {
        if (num2 == 0) {
            printf("No se puede dividir entre 0.");
        } else {
            resultado = num1/num2;
        }         
    } else {
        switch (operacion)
        {
        case '+':
            resultado = num1 + num2;
            break;
        case '-':
            resultado = num1 - num2;
            break;
        case '*':
            resultado = num1 * num2;
            break;
        default:
            break;
        }
    }
    
    
    printf("El resultado de %ld %c %ld es %ld""\n", num1, operacion, num2, resultado);
   


    return 0;
}