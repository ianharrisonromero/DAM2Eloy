#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

#define MIN_RESULT 1
#define MAX_RESULT 100
#define N_RANDOMS 3

int main() {
    pid_t id;
    int fd[2];
    pipe(fd);
    id = fork();

    if (id != 0) {
        // Parent process
        int random_number = 0; // Initialize random_number for the parent

        close(fd[0]);

        for (int i = 0; i < N_RANDOMS; i++) {
            int random_range = (rand() % (MAX_RESULT - MIN_RESULT + 1)) + MIN_RESULT;
            printf("Random number generated by PARENT in the range [%d, %d]: %d\n", MIN_RESULT, MAX_RESULT, random_range);
            write(fd[1], &random_range, sizeof(int));
        }

        close(fd[1]);
    } else {
        // Child process
        int random_number = 0; // Initialize random_number for the child
        close(fd[1]);
        sleep(3);

        printf("I'm the child, I've received these numbers:\n");

        for (int i = 0; i < N_RANDOMS; i++) {
            read(fd[0], &random_number, sizeof(int));
            printf("%d\n", random_number);
        }

        close(fd[0]);
    }

    return 0;
}