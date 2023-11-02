#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main()
{
  char palabra[100], letraDeEnMedio;
  int longitud, longitudReal;
  bool esCapicua = true;
  printf("introduce una palabra para saber si es capicua: \n");
  fgets(palabra, sizeof(palabra), stdin);
  longitud = strlen(palabra) -1;
  letraDeEnMedio = palabra[longitud/2];


  for (int i = 0; i < longitud/2; i++)
  {
    for (int j = longitud; j > longitud/2 -1; j--)
    {
      if (palabra[i] != palabra[j])
      {
        esCapicua = false;
      }
    }
    
  }

  if (esCapicua)
  {
    printf("La palabra %s tiene %d caracteres y es capicua. \n", palabra, longitud);

  } else
  {
    printf("La palabra %s tiene %d caracteres y no es capicua. \n", palabra, longitud);
  }
  
  
  


  return 0;


}