```java
public static String crearCuadrado(int altura, int anchura, char caracter) {
    String cuadradoTerminado = "";

    for (int i = 0; i < altura; i++) {
        for (int j = 0; j < anchura; j++) {
            if (i == 0 || i == altura - 1) {
                cuadradoTerminado += caracter;
            } else {
                if (j == 0 || j == anchura - 1) {
                    cuadradoTerminado += caracter;

                } else {
                    cuadradoTerminado += " ";

                }
            }
        }
        cuadradoTerminado += "\n";
    }

    return cuadradoTerminado;
}
```
