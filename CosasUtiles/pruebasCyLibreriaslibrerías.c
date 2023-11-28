#include <stdio.h>   // Manejo de entrada/salida estándar
#include <stdlib.h>  // Funciones de utilidad general
#include <string.h>  // Funciones de manipulación de cadenas de caracteres
#include <ctype.h>   // Funciones para clasificación y manipulación de caracteres
#include <math.h>    // Funciones matemáticas
#include <time.h>    // Funciones para trabajar con el tiempo
#include <limits.h>  // Constantes de límites de tipos de datos
#include <stdbool.h> // Definiciones para valores booleanos
#include <stddef.h>  // Definiciones estándar
#include <stdint.h>  // Tipos de datos enteros con anchos específicos
#include <stdarg.h>  // Manipulación de argumentos variables
#include <assert.h>  // Macros para aserciones
#include <errno.h>   // Definiciones para códigos de error
#include <fcntl.h>   // Control de archivos
#include <signal.h>  // Manejo de señales
#include <unistd.h>  // Funciones para el sistema operativo POSIX
#include <wchar.h>   // Funciones y macros para manipular caracteres anchos
#include <locale.h>  // Manejo de configuraciones locales

int main(int argc, char const *argv[])
{
    char ch;
    ch = getchar();

    printf("%c\n", ch);
    return 0;
}
