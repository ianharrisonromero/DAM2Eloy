#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int main() {  

    char *program = "ls";
    char *arguments[] = {"ls","/", NULL};

    pid_t id = fork();

    if (id != 0){

      execvp(program, arguments);

    } else {

        int file = open("output.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);

        if (file < 0) {
          perror("open");
          return 1;
        }  
        dup2(file, STDOUT_FILENO); 
        execvp(program, arguments);
        close(file);
    }

    

    return 0;
}
