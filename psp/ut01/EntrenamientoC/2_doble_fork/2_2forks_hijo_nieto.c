
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>

#define MAX_FORKS 2
#define N_RANDOMS 20

int main(){

    pid_t hijo;
    pid_t nieto;
    hijo = fork();

    //hijo crea hijo
    if (hijo == 0){
        nieto = fork();
        printf("soy el hijo creando un nieto......");
    }

    //padre
    if(hijo != 0){
        printf("soy el padre\n");
    }

    //hijo
    if (hijo == 0 && nieto != 0){
        printf("soy el hijo\n");

    }

    //nieto
    if (nieto == 0){
        printf("soy el hijo del hijo\n");
    }

}


