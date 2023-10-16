#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>
#include <sys/wait.h> 


int main(void){
  for (int i = 1; i < 11; i++){
    pid_t idhijo;
    idhijo = fork();
    if (idhijo==0){
      printTable(i);
      exit(0);
  }
  for (int i=1 ; i<11 ; i++){
    wait(NULL);
  }
}

int printTable(int numeroRecibido){
  printf("Tabla del %d -> \n", numeroRecibido);
  for (int i=1 ; i <11 ; i++){
    printf("%d x %d = %d \n" , numeroRecibido, i , numeroRecibido*i);
  }
}
  
