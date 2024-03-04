##ARRAYLIST

1. **ArrayList - Declaración e inicialización**:

    ```java
    ArrayList<String> list = new ArrayList<>();
    ```

2. **ArrayList - Añadir elementos**:

    ```java
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(10);
    numbers.add(20);
    numbers.add(30);
    ```

3. **ArrayList - Obtener elemento por índice**:

    ```java
    ArrayList<String> fruits = new ArrayList<>();
    fruits.add("Manzana");
    fruits.add("Plátano");
    fruits.add("Naranja");

    String fruit = fruits.get(1); // Obtiene el segundo elemento (índice 1)
    System.out.println("Fruta obtenida: " + fruit);
    ```

4. **ArrayList - Eliminar elemento por índice**:

    ```java
    ArrayList<String> colors = new ArrayList<>();
    colors.add("Rojo");
    colors.add("Verde");
    colors.add("Azul");

    colors.remove(1); // Elimina el segundo elemento (índice 1)
    ```

5. **ArrayList - Tamaño del ArrayList**:

    ```java
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(10);
    numbers.add(20);
    numbers.add(30);

    int size = numbers.size();
    System.out.println("Tamaño de la lista: " + size);
    ```

6. **ArrayList - Verificar si está vacío**:

    ```java
    ArrayList<String> list = new ArrayList<>();
    boolean isEmpty = list.isEmpty();
    System.out.println("¿La lista está vacía? " + isEmpty);
    ```

7. **ArrayList - Verificar si contiene un elemento**:

    ```java
    ArrayList<String> fruits = new ArrayList<>();
    fruits.add("Manzana");
    fruits.add("Plátano");
    fruits.add("Naranja");

    boolean contains = fruits.contains("Manzana");
    System.out.println("¿La lista contiene manzana? " + contains);
    ```
