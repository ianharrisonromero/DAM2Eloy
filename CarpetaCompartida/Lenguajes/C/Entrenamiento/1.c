#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#define MIN_RESULT 1
#define MAX_RESULT 100

int main (){
    srand(time(NULL));
    pid_t id;
    id = fork();
    int random_number;
    int random_number2;
    if (id != 0)
    {
        random_number = rand();
        printf("Random number: %d\n", random_number);

        // To generate a random number within a specific range, you can use modulo
        
        int random_range = (rand() % (MAX_RESULT - MIN_RESULT + 1)) + MIN_RESULT;
        printf("Random number generated by FATHER in the range [%d, %d]: %d\n", MIN_RESULT, MAX_RESULT, random_range);

        return 0;

    }
    else
    {
        random_number2 = rand();
        printf("Random number: %d\n", random_number);

        // To generate a random number within a specific range, you can use modulo
        
        int random_range = (rand() % (MAX_RESULT - MIN_RESULT + 1)) + MIN_RESULT;
        printf("Random number generated by CHILD in the range [%d, %d]: %d\n", MIN_RESULT, MAX_RESULT, random_range);

        return 0;
    }
    

}