##HASH MAP

1. **HashMap - Declaración e inicialización**:

    ```java
    HashMap<String, Integer> map = new HashMap<>();
    ```

2. **HashMap - Añadir elementos**:

    ```java
    HashMap<String, String> capitals = new HashMap<>();
    capitals.put("España", "Madrid");
    capitals.put("Francia", "París");
    capitals.put("Italia", "Roma");
    ```

3. **HashMap - Obtener valor por clave**:

    ```java
    HashMap<String, Integer> ages = new HashMap<>();
    ages.put("Juan", 30);
    ages.put("María", 25);
    ages.put("Pedro", 35);

    int age = ages.get("María");
    System.out.println("La edad de María es: " + age);
    ```

4. **HashMap - Eliminar elemento por clave**:

    ```java
    HashMap<String, String> capitals = new HashMap<>();
    capitals.put("España", "Madrid");
    capitals.put("Francia", "París");
    capitals.put("Italia", "Roma");

    capitals.remove("Francia");
    ```

5. **HashMap - Verificar si contiene una clave**:

    ```java
    HashMap<String, String> capitals = new HashMap<>();
    capitals.put("España", "Madrid");
    capitals.put("Francia", "París");
    capitals.put("Italia", "Roma");

    boolean containsKey = capitals.containsKey("Francia");
    System.out.println("¿La clave 'Francia' está presente? " + containsKey);
    ```

6. **HashMap - Verificar si contiene un valor**:

    ```java
    HashMap<String, String> capitals = new HashMap<>();
    capitals.put("España", "Madrid");
    capitals.put("Francia", "París");
    capitals.put("Italia", "Roma");

    boolean containsValue = capitals.containsValue("Roma");
    System.out.println("¿El valor 'Roma' está presente? " + containsValue);
    ```
