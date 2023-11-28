**exec():**

    c
    Copy code
    #include <unistd.h>

    int main() {
        // Después de fork(), en el proceso hijo, reemplazamos la imagen del proceso con un nuevo programa.
        if (fork() == 0) {
            execl("/bin/ls", "ls", "-l", NULL);
        } else {
            // El proceso padre puede realizar otras tareas mientras el hijo ejecuta el nuevo programa.
            wait(NULL);
        }
        return 0;
    }

**wait() y waitpid():**

    
    #include <sys/wait.h>
    #include <unistd.h>
    #include <stdio.h>

    int main() {
        pid_t childPid;

        if ((childPid = fork()) == 0) {
            // Código del proceso hijo
            // ...
        } else {
            // Código del proceso padre
            int status;
            wait(&status); // Espera a que el proceso hijo termine y recupera su estado de salida.
            // Puedes acceder al código de salida con WEXITSTATUS(status)
        }

        return 0;
    }

**wait(NULL)**

    #include <stdio.h>
    #include <stdlib.h>
    #include <unistd.h>

    #define READ 0
    #define WRITE 1

    int main() {
        int fd[2];
        pid_t pid;

        // Crear un pipe
        if (pipe(fd) == -1) {
            perror("pipe");
            exit(EXIT_FAILURE);
        }

        // Bifurcar el proceso actual para crear un proceso hijo
        pid = fork();
        if (pid == -1) {
            perror("fork");
            exit(EXIT_FAILURE);
        }

        if (pid == 0) {  // Código del proceso hijo
            int numero_recibido;
            close(fd[WRITE]);  // El hijo no escribirá en el pipe, así que cerramos el descriptor de escritura

            // Leer el número del pipe
            read(fd[READ], &numero_recibido, sizeof(numero_recibido));
            close(fd[READ]);  // Cerrar el descriptor de lectura después de leer

            // Imprimir el número recibido
            printf("Proceso hijo recibió el número: %d\n", numero_recibido);
            exit(EXIT_SUCCESS);

        } else {  // Código del proceso padre
            int numero_a_enviar = 42;  // Este es el número que el padre enviará al hijo
            close(fd[READ]);  // El padre no leerá del pipe, así que cerramos el descriptor de lectura

            // Escribir el número en el pipe
            write(fd[WRITE], &numero_a_enviar, sizeof(numero_a_enviar));
            close(fd[WRITE]);  // Cerrar el descriptor de escritura después de escribir

            // Esperar a que el proceso hijo termine
            wait(NULL);
            printf("Proceso padre terminó\n");
        }

        return 0;
    }


**waitpid()**

    #include <sys/wait.h>
    #include <unistd.h>
    #include <stdio.h>

    int main() {
        pid_t childPid;

        if ((childPid = fork()) == 0) {
            // Código del proceso hijo
            printf("Proceso hijo ejecutando...\n");
            sleep(3); // Simula algún trabajo en el proceso hijo
            printf("Proceso hijo terminado.\n");
        } else {
            // Código del proceso padre
            printf("Esperando a que el proceso hijo termine...\n");
            int status;

            // waitpid espera a que el proceso hijo con el PID especificado termine
            // y almacena su estado de salida en la variable 'status'.
            // El tercer parámetro (0 en este caso) indica opciones adicionales.
            waitpid(childPid, &status, 0);

            if (WIFEXITED(status)) {
                // El proceso hijo terminó normalmente
                printf("Proceso hijo terminado con código de salida: %d\n", WEXITSTATUS(status));
            } else if (WIFSIGNALED(status)) {
                // El proceso hijo fue terminado por una señal
                printf("Proceso hijo terminado por señal: %d\n", WTERMSIG(status));
            }
        }

        return 0;
    }

**exit():**

    c
    Copy code
    #include <stdlib.h>

    int main() {
        // Código del proceso
        // ...

        // Termina el proceso y devuelve un código de salida al sistema operativo.
        exit(0);
    }

**pipe():**

    c
    Copy code
    #include <unistd.h>

    int main() {
        int fd[2];
        char buffer[50];

        // Crear una tubería
        if (pipe(fd) == -1) {
            perror("pipe");
            return 1;
        }

        if (fork() == 0) {
            // Código del proceso hijo
            close(fd[0]);  // Cerramos el extremo de lectura, ya que vamos a escribir
            write(fd[1], "Hola, padre", sizeof("Hola, padre"));
            close(fd[1]);  // Cerramos el extremo de escritura después de escribir
        } else {
            // Código del proceso padre
            close(fd[1]);  // Cerramos el extremo de escritura, ya que vamos a leer
            read(fd[0], buffer, sizeof(buffer));
            close(fd[0]);  // Cerramos el extremo de lectura después de leer
            printf("Mensaje recibido: %s\n", buffer);
        }

        return 0;
    }

**dup()**

    c
    Copy code
    #include <unistd.h>
    #include <fcntl.h>

    int main() {
        int fileDescriptor = open("output.txt", O_WRONLY | O_CREAT | O_TRUNC, S_IRWXU);

        // Duplicar el descriptor de archivo estándar de salida (stdout)
        int newDescriptor = dup(fileDescriptor);

        // Ahora, newDescriptor puede usarse en lugar de fileDescriptor para escribir en el archivo.

        // ... Código que escribe en el nuevo descriptor ...

        close(fileDescriptor);
        close(newDescriptor);

        return 0;
    }

**dup2():**

    #include <stdio.h>
    #include <fcntl.h>
    #include <unistd.h>

    int main() {
        int fileDescriptor;

        // Abrir o crear un archivo para escribir
        fileDescriptor = open("output.txt", O_WRONLY | O_CREAT | O_TRUNC, S_IRWXU);

        if (fileDescriptor == -1) {
            perror("Error al abrir el archivo");
            return 1;
        }

        // Duplicar el descriptor de archivo estándar de salida (stdout)
        if (dup2(fileDescriptor, STDOUT_FILENO) == -1) {
            perror("Error al duplicar el descriptor");
            return 1;
        }

        // Cerrar el descriptor de archivo original
        close(fileDescriptor);

        // Ahora, todo lo que se escriba en stdout se dirigirá al archivo output.txt
        printf("Este mensaje se escribirá en output.txt\n");

        return 0;
    }

**kill():**

    
    #include <signal.h>
    #include <unistd.h>

    int main() {
        pid_t targetProcessId = /* obtener el ID del proceso objetivo */;

        // Enviar la señal SIGTERM al proceso objetivo
        kill(targetProcessId, SIGTERM);

        return 0;
    }

**signal handler**

    #include <stdio.h>
    #include <signal.h>
    #include <unistd.h>

    // Prototipo de la función del signal handler
    void sigintHandler(int signo);

    int main() {
        // Establecer el signal handler para SIGINT
        if (signal(SIGINT, sigintHandler) == SIG_ERR) {
            perror("Error al establecer el signal handler");
            return 1;
        }

        printf("Ctrl+C está habilitado. Prueba a presionar Ctrl+C.\n");

        // Ciclo infinito simulando alguna tarea
        while (1) {
            sleep(1);
        }

        return 0;
    }

    // Definición de la función del signal handler
    void sigintHandler(int signo) {
        printf("\nSe recibió la señal SIGINT (Ctrl+C).\n");

        // Puedes agregar aquí cualquier código que quieras ejecutar cuando se recibe la señal

        // Puedes restaurar el comportamiento predeterminado de la señal si lo deseas
        // signal(SIGINT, SIG_DFL);

        // O simplemente puedes ignorar la señal
        // signal(SIGINT, SIG_IGN);
    }

**signal handler con fork**

    #include <stdio.h>
    #include <stdlib.h>
    #include <signal.h>
    #include <unistd.h>
    #include <sys/wait.h>

    // Prototipo de la función del signal handler
    void sigintHandler(int signo);

    int main() {
        // Establecer el signal handler para SIGINT
        if (signal(SIGINT, sigintHandler) == SIG_ERR) {
            perror("Error al establecer el signal handler");
            return 1;
        }

        printf("Ctrl+C está habilitado. Prueba a presionar Ctrl+C.\n");

        // Variable para almacenar el PID del proceso hijo
        pid_t childPid;

        // Ciclo infinito simulando alguna tarea
        while (1) {
            // Crear un proceso hijo para realizar una tarea
            if ((childPid = fork()) == 0) {
                // Código del proceso hijo
                printf("Proceso hijo ejecutando una tarea...\n");
                sleep(2);  // Simular una tarea que toma 2 segundos
                exit(0);   // Salir del proceso hijo después de completar la tarea
            } else if (childPid == -1) {
                perror("Error al crear el proceso hijo");
                return 1;
            } else {
                // Código del proceso padre
                int status;

                // Esperar a que el proceso hijo termine
                waitpid(childPid, &status, 0);

                printf("Proceso hijo terminado.\n");
            }
        }

        return 0;
    }

    // Definición de la función del signal handler
    void sigintHandler(int signo)
