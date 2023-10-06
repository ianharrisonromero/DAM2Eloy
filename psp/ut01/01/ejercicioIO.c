#include <stdio.h>

int main(void){
  int num = 42;
  printf("Esto es un número: %d\n" , num );
  scanf("%d" , &num);
  printf("El nuevo número es: %d\n" , num );
  return 0;
}