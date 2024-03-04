
```java
    public static String createEmptyPiramid(int altura, char caracter) {
        StringBuilder piramide = new StringBuilder();
        for (int i = 1; i <= altura; i++) {
            // Espacios a la izquierda
            for (int j = 0; j < altura - i; j++) {
                piramide.append(" ");
            }
            // Carácter en la posición central o los extremos
            if (i == 1 || i == altura) {
                for (int j = 0; j < (2 * i) - 1; j++) {
                    piramide.append(caracter);
                }
            } else {
                piramide.append(caracter); // Primer carácter
                // Espacios en el medio
                for (int j = 0; j < (2 * i) - 3; j++) {
                    piramide.append(" ");
                }
                piramide.append(caracter); // Último carácter
            }
            piramide.append("\n"); // Nueva línea para la siguiente fila
        }
        return piramide.toString();
    }
``````