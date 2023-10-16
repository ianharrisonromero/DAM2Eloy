#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <stdbool.h>

int main(void) {

  long num;
  bool esPrimo = true;

  printf("Ingresa un numero para saber si es primo o no: ");
  scanf("%ld", &num);

  for (int i = 2; i < sqrt(num) ; i++)
  {
    if (num%i == 0)
    {
      esPrimo = false;
    }
    
  }

  if (esPrimo)
    {
      printf("El número %ld es primo\n", num);
    }else
    {
      printf("El número %ld no primo\n", num);
    }
  

  return 0;
}