```java
public static String createHollowDiamond(int altura, char caracter) {
        StringBuilder romboHueco = new StringBuilder();

        // Parte superior del rombo
        for (int i = 1; i <= altura / 2 + 1; i++) {
            for (int j = 0; j < altura / 2 + 1 - i; j++) {
                romboHueco.append(" ");
            }
            if (i == 1) {
                romboHueco.append(caracter);
            } else {
                romboHueco.append(caracter); // Primer carácter
                for (int j = 0; j < (2 * i) - 3; j++) {
                    romboHueco.append(" ");
                }
                romboHueco.append(caracter); // Último carácter
            }
            romboHueco.append("\n");
        }

        // Parte inferior del rombo
        for (int i = altura / 2; i >= 1; i--) {
            for (int j = 0; j < altura / 2 + 1 - i; j++) {
                romboHueco.append(" ");
            }
            if (i == 1) {
                romboHueco.append(caracter);
            } else {
                romboHueco.append(caracter); // Primer carácter
                for (int j = 0; j < (2 * i) - 3; j++) {
                    romboHueco.append(" ");
                }
                romboHueco.append(caracter); // Último carácter
            }
            romboHueco.append("\n");
        }

        return romboHueco.toString();
    }
``````