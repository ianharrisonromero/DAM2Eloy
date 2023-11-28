// 3. Crea un programa que reciba por parámetro un número entero positivo n. Este número indicará el
// número de hijos. Cada hijo generará un fichero con la posibles combinación de caracteres de
// esa longitud. El hijo 1 una letra, el hijo 2 dos letras 'aa' a la 'zz', etc.
// Los nombres serán datos1.txt, datos2.txt, etc.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>

int main(int n_hijos)
{

  pid_t child;

  printf("pid del padre : %d", child);

  for (int i = 0; i < n_hijos; i++)
  {
    child = fork();
    if (child == 0)
    {
      break;
    }
  }

  const char *filename = "datos";
}
