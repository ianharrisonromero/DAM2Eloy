
```java
public static String crearPiramideInvertida(int altura, char caracter) {
    StringBuilder piramide = new StringBuilder();

    for (int i = altura; i >= 1; i--) {
        // Agregar espacios al principio de cada fila
        for (int j = 0; j < altura - i; j++) {
            piramide.append(" ");
        }

        // Agregar caracteres en cada fila
        for (int k = 0; k < i * 2 - 1; k++) {
            piramide.append(caracter);
        }

        piramide.append("\n");
    }

    return piramide.toString();
}

``````