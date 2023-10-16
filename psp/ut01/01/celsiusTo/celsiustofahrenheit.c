#include <stdio.h>
#include <stdlib.h>

int main(void) {

  long celsius;
  long fahrenheit;

  printf("Ingrese una temperatura en celsius: \n");
  scanf("%ld" , &celsius);

  fahrenheit = (celsius * 9/5) + 32;

  printf("%ld grados celsius son %ld fahrenheit \n", celsius, fahrenheit);
  
  return 0;
}
