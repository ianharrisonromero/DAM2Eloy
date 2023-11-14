#include <stdio.h>
#include <unistd.h>
#include <signal.h>
#include <stdlib.h>


void ladrar(int signo){
  printf("Guau!!");
}

void morder(int signo){
  printf("gRrr!!");
}

int main (){
  signal(3, ladrar);
  signal(4, morder);

  while (1)
  {
    printf(".");
    fflush(stdout);
    sleep(1);
  }
  

}