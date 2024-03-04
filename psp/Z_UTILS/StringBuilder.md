#StringBuilder

```java
// Declaración de un StringBuilder
StringBuilder stringBuilder = new StringBuilder();

// Conversión de String a StringBuilder
String str = "Hola";
StringBuilder sb = new StringBuilder(str);
``````

// Métodos muy usados en StringBuilder:

1. **append()**: Este método es fundamental en StringBuilder y se utiliza para agregar una representación de cualquier tipo de datos al final de la secuencia actual.

    ```java
    StringBuilder sb = new StringBuilder("Hola ");
    sb.append("mundo!");
    System.out.println(sb.toString()); // Salida: Hola mundo!

2. **insert()**: Similar a append(), pero inserta la representación de cualquier tipo de datos en una posición específica dentro de la secuencia actual.

    ```java
    StringBuilder sb = new StringBuilder("mundo!");
    sb.insert(0, "Hola ");
    System.out.println(sb.toString()); // Salida: Hola mundo!

3. **delete()**: Elimina una secuencia de caracteres de la secuencia actual de StringBuilder.

    ```java
    StringBuilder sb = new StringBuilder("Hola mundo!");
    sb.delete(5, 11);
    System.out.println(sb.toString()); // Salida: Hola!


4. **deleteCharAt()**: Elimina el carácter en una posición específica de la secuencia actual de StringBuilder.

    ```java
    StringBuilder sb = new StringBuilder("Hola mundo!");
    sb.deleteCharAt(4);
    System.out.println(sb.toString()); // Salida: Hla mundo!


5. **replace()**: Reemplaza una secuencia de caracteres en la secuencia actual de StringBuilder con otra secuencia de caracteres.

    ```java
    StringBuilder sb = new StringBuilder("Hola mundo!");
    sb.replace(0, 4, "Adiós");
    System.out.println(sb.toString()); // Salida: Adiós mundo!


6. **reverse()**: Invierte el contenido de la secuencia actual de StringBuilder.

    ```java
    StringBuilder sb = new StringBuilder("Hola mundo!");
    sb.reverse();
    System.out.println(sb.toString()); // Salida: !odnum aloH


7. **substring()**: Devuelve una subcadena de la secuencia actual de StringBuilder.

    ```java
    StringBuilder sb = new StringBuilder("Hola mundo!");
    String sub = sb.substring(5);
    System.out.println(sub); // Salida: mundo!


8. **capacity()**: Devuelve la capacidad actual del StringBuilder, es decir, el número máximo de caracteres que puede contener sin necesidad de aumentar su tamaño interno.

    ```java
    StringBuilder sb = new StringBuilder("Hola mundo!");
    int cap = sb.capacity();
    System.out.println(cap); // Salida: 23 (ejemplo, puede variar)


9. **ensureCapacity(int minimumCapacity)**: Asegura que la capacidad del StringBuilder sea al menos igual a un valor específico.

    ```java
    StringBuilder sb = new StringBuilder();
    sb.ensureCapacity(20); // Asegura que la capacidad sea al menos 20 caracteres


10. **trimToSize()**: Reduce la capacidad del StringBuilder al número actual de caracteres, lo que puede ser útil para ahorrar memoria si has terminado de construir la cadena.

    ```java
    StringBuilder sb = new StringBuilder("Hola mundo!");
    sb.trimToSize();


11. **indexOf(String str)**: Devuelve la posición de la primera aparición de la subcadena especificada dentro de la secuencia actual de StringBuilder.

    ```java
    StringBuilder sb = new StringBuilder("Hola mundo!");
    int index = sb.indexOf("mundo");
    System.out.println(index); // Salida: 5


12. **lastIndexOf(String str)**: Devuelve la posición de la última aparición de la subcadena especificada dentro de la secuencia actual de StringBuilder.

    ```java
    StringBuilder sb = new StringBuilder("Hola mundo mundo!");
    int lastIndex = sb.lastIndexOf("mundo");
    System.out.println(lastIndex); // Salida: 12
    ```

13. **length()**: Devuelve la longitud (número de caracteres) de la secuencia actual de StringBuilder.

    ```java
    StringBuilder sb = new StringBuilder("Hola mundo!");
    int len = sb.length();
    System.out.println(len); // Salida: 11
    ```

14. **setCharAt(int index, char c)**: Establece el carácter en la posición especificada dentro de la secuencia actual de StringBuilder.

    ```java
    StringBuilder sb = new StringBuilder("Hola mundo!");
    sb.setCharAt(5, 'M');
    System.out.println(sb.toString()); // Salida: Hola Mundo!
    ```


