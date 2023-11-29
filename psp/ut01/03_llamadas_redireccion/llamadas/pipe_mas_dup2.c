Redirección entre procesos
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

    // Aquí está el análisis paso a paso :

    // Se crea un pipe utilizando la función pipe.Un pipe tiene dos extremos : uno para
    // escritura(fd[1]) y otro para lectura(fd[0])
    // .

    // Se realiza un fork para crear un nuevo proceso hijo.El proceso hijo ejecutará el comando ls
    // - l - a.

    // En el proceso hijo(pid == 0),
    // se cierra el extremo de lectura del pipe(fd[0]), ya que no se va a leer desde él.Luego, se redirige la salida estándar(STDOUT_FILENO)
    // al extremo de escritura del pipe(fd[1]).Después de esta redirección, cuando el proceso hijo use printf o cualquier función de salida estándar, la salida se dirigirá al pipe en lugar de la pantalla.Finalmente, se cierra el extremo de escritura del pipe(fd[1]), ya que ya no se necesita.

    //                                                                                                                                                     Se utiliza la función execvp para ejecutar el comando ls con los argumentos
    //                                                                                                                                                     - l y - a.Si execvp tiene éxito,
    // el código después de esta llamada no se ejecuta.Si falla, se imprime un mensaje de error utilizando perror y se sale del proceso hijo con exit(EXIT_FAILURE).

    // En el proceso padre,
    // se cierra el extremo de escritura del pipe(fd[1]), ya que no se va a escribir en él.Luego, se lee la salida del comando del extremo de lectura del pipe(fd[0]) en un bucle usando la función read.La lectura se realiza en bloques de hasta 1023 bytes y se termina cuando no hay más datos para leer.

    // Se imprime el contenido del buffer en el proceso padre.

    // Se cierra el extremo de lectura del pipe(fd[0]) después de leer todos los datos.

    // Se utiliza la función wait para esperar a que el proceso hijo termine.

    int
    main()
{
    int fd[2]; // Descriptores de archivo para el pipe
    pid_t pid;

    // Crear un pipe
    if (pipe(fd) == -1)
    {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    pid = fork();
    if (pid < 0)
    {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (pid == 0)
    {                 // Proceso hijo
        close(fd[0]); // Cerrar el extremo de lectura del pipe

        // Redirigir la salida estándar al extremo de escritura del pipe
        dup2(fd[1], STDOUT_FILENO);
        close(fd[1]);

        // Datos para execvp: comando "ls" con argumentos "-l" y "-a"
        char *cmd = "ls";
        char *args[] = {"ls", "-l", "-a", NULL};

        execvp(cmd, args);
        perror("execvp"); // Se ejecutará solo si execvp falla
        exit(EXIT_FAILURE);
    }
    else
    { // Proceso padre
        char buffer[1024];
        ssize_t bytes;

        close(fd[1]); // Cerrar el extremo de escritura del pipe

        // Leer la salida del comando
        while ((bytes = read(fd[0], buffer, sizeof(buffer) - 1)) > 0)
        {
            buffer[bytes] = '\0'; // Asegurarse de que es una cadena terminada en NULL
            printf("%s", buffer);
        }

        close(fd[0]); // Cerrar el extremo de lectura del pipe
        wait(NULL);   // Esperar a que el proceso hijo termine
    }

    return 0;
}