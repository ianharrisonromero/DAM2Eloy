```java

    public static String crearTrianguloInvertido(int altura, char caracter) {
        StringBuilder triangulo = new StringBuilder();

        for (int i = 0; i < altura; i++) {
            // Agregar espacios al principio de cada fila
            for (int j = 0; j < i; j++) {
                triangulo.append(" ");
            }

            // Agregar caracteres en cada fila
            for (int k = 0; k < altura - i; k++) {
                triangulo.append(caracter);
            }

            triangulo.append("\n");
        }

        return triangulo.toString();
    }

```

0000000000
 000000000
  00000000
   0000000
    000000
     00000
      0000
       000
        00
         0