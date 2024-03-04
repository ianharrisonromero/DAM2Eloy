```java
public static String crearTrianguloRectangulo(int altura, char caracter) {
    StringBuilder triangulo = new StringBuilder();

    for (int i = 0; i < altura; i++) {
        for (int j = 0; j <= i; j++) {
            triangulo.append(caracter);
        }
        triangulo.append("\n");
    }

    return triangulo.toString();
}

``````
**output**

0
00
000
0000
00000
000000
0000000
00000000
000000000
0000000000