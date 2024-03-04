```java
public static String crearRombo(int altura, char caracter) {
    StringBuilder rombo = new StringBuilder();

    // Parte superior del rombo
    for (int i = 0; i < altura; i++) {
        for (int j = 0; j < altura - i - 1; j++) {
            rombo.append(" ");
        }

        for (int k = 0; k < i * 2 + 1; k++) {
            rombo.append(caracter);
        }

        rombo.append("\n");
    }

    // Parte inferior del rombo
    for (int i = altura - 2; i >= 0; i--) {
        for (int j = 0; j < altura - i - 1; j++) {
            rombo.append(" ");
        }

        for (int k = 0; k < i * 2 + 1; k++) {
            rombo.append(caracter);
        }

        rombo.append("\n");
    }

    return rombo.toString();
}

``````