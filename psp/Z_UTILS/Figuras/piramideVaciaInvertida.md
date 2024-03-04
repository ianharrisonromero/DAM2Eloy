```java
public static String createEmptyInvertedPyramid(int altura, char caracter) {
        StringBuilder piramideInvertida = new StringBuilder();
        for (int i = altura; i >= 1; i--) {
            // Espacios a la izquierda
            for (int j = 0; j < altura - i; j++) {
                piramideInvertida.append(" ");
            }
            // Carácter en la posición central o los extremos
            if (i == 1 || i == altura) {
                for (int j = 0; j < (2 * i) - 1; j++) {
                    piramideInvertida.append(caracter);
                }
            } else {
                piramideInvertida.append(caracter); // Primer carácter
                // Espacios en el medio
                for (int j = 0; j < (2 * i) - 3; j++) {
                    piramideInvertida.append(" ");
                }
                piramideInvertida.append(caracter); // Último carácter
            }
            piramideInvertida.append("\n"); // Nueva línea para la siguiente fila
        }
        return piramideInvertida.toString();
    }

```
