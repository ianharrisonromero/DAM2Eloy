#include <stdio.h>
#include <string.h>
#define BUFFER_SIZE 1024

int main (void){

    char cadena[BUFFER_SIZE];
    int vocales=0;
    int mayusculas=0;
    int minusculas=0;

    printf("Introduzca una cadena de caracteres: ");
    fgets(cadena, sizeof(cadena), stdin);

    for (int i = 0 ; i < strlen(cadena) ; i++){
        if (cadena[i] == 'a' || cadena[i] == 'e' ||  
            cadena[i] == 'i' || cadena[i] == 'o' ||  
            cadena[i] == 'u')
        {
            vocales +=1;
            minusculas +=1;
        }

        if (cadena[i] == 'A' || cadena[i] == 'E' || 
            cadena[i] == 'I' || cadena[i] == 'O' || 
            cadena[i] == 'U')
        {
            vocales +=1;
            mayusculas +=1;
        }
        
    }

    printf("Hay %d vocales, %d mayusculas y %d minusculas.", vocales, mayusculas, minusculas);


}