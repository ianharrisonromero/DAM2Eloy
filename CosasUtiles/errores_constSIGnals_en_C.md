##**ERRORLS**

    #include <stdio.h>
    #include <stdlib.h>
    #include <unistd.h>
    #include <sys/types.h>
    #include <sys/wait.h>

    int main() {
        // Error handling for fork
        pid_t pid = fork();

        if (pid < 0) {
            perror("Fork failed");
            exit(EXIT_FAILURE);
        } else if (pid == 0) {
            // Child process
            printf("This is the child process.\n");
            // Uncomment the line below to simulate an error in the child process
            // exit(EXIT_FAILURE);
        } else {
            // Parent process
            printf("This is the parent process.\n");
            // Uncomment the line below to simulate an error in the parent process
            // exit(EXIT_FAILURE);
        }

        // Error handling for pipe
        int pipefd[2];
        if (pipe(pipefd) == -1) {
            perror("Pipe creation failed");
            exit(EXIT_FAILURE);
        }

        // Error handling for fopen
        FILE *file = fopen("example.txt", "r");
        if (file == NULL) {
            perror("Error opening file");
            exit(EXIT_FAILURE);
        }

        // Error handling for open
        int file = open("example.txt", O_RDONLY);
        if (file == -1) {
        perror("Error opening file");
        exit(EXIT_FAILURE);
        }

        // Uncomment the line below to simulate an error while reading from the file
        // char buffer[100];
        // if (fgets(buffer, sizeof(buffer), file) == NULL) {
        //     perror("Error reading from file");
        //     exit(EXIT_FAILURE);
        // }

        fclose(file);

        // Uncomment the line below to simulate a specific error code
        // exit(EXIT_FAILURE);

        return 0;
    }

SIGTERM (Termination):

Constant Value: 15
SIGINT (Interrupt):

Constant Value: 2
SIGKILL (Kill):

Constant Value: 9
SIGUSR1 (User-defined signal 1):

Constant Value: 10
SIGUSR2 (User-defined signal 2):

Constant Value: 12
SIGSEGV (Segmentation fault):

Constant Value: 11
SIGCHLD (Child process status change):

Constant Value: Can vary (commonly 17)
SIGHUP (Hangup):

Constant Value: 1
SIGPIPE (Broken pipe):

Constant Value: 13
SIGALRM (Alarm clock):

Constant Value: 14
