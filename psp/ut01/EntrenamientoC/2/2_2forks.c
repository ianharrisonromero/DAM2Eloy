//Crea un proceso que cree dos procesos hijos, luego generará N (20) números aleatorios. 
//Enviará los pares al primer hijo, los impares al segundo. Los hijos escribirán por pantalla 
//"Soy el hijo 1|2, he recibido ". Por cada número que mande el padre.

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>
#define MIN_RESULT 1
#define MAX_RESULT 100
#define N_RANDOMS 20


