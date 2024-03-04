##FILE

1. **exists()**: Comprueba si el archivo o directorio representado por esta instancia de File existe en el sistema de archivos.

    ```java
    File file = new File("archivo.txt");
    boolean exists = file.exists();
    System.out.println("¿El archivo existe? " + exists);
    ```
2. **isFile()**: Comprueba si la ruta especificada por esta instancia de File representa un archivo regular en el sistema de archivos.

    ```java
    File file = new File("archivo.txt");
    boolean isFile = file.isFile();
    System.out.println("¿Es un archivo? " + isFile);
    ```
3. **isDirectory()**: Comprueba si la ruta especificada por esta instancia de File representa un directorio en el sistema de archivos.

    ```java
    File directory = new File("directorio");
    boolean isDirectory = directory.isDirectory();
    System.out.println("¿Es un directorio? " + isDirectory);
    ```
4. **getName()**: Devuelve el nombre del archivo o directorio representado por esta instancia de File.

    ```java
    File file = new File("ruta/archivo.txt");
    String name = file.getName();
    System.out.println("Nombre del archivo: " + name);
    ```
5. **getParent()**: Devuelve la ruta del directorio padre del archivo o directorio representado por esta instancia de File.

    ```java
    File file = new File("ruta/archivo.txt");
    String parent = file.getParent();
    System.out.println("Directorio padre: " + parent);
    ```
6. **length()**: Devuelve la longitud del archivo en bytes.

    ```java
    File file = new File("archivo.txt");
    long length = file.length();
    System.out.println("Tamaño del archivo: " + length + " bytes");
    ```
7. **canRead()**: Comprueba si el archivo puede ser leído.

    ```java
    File file = new File("archivo.txt");
    boolean canRead = file.canRead();
    System.out.println("¿Se puede leer el archivo? " + canRead);
    ```
8. **canWrite()**: Comprueba si el archivo puede ser modificado o escrito.

    ```java
    File file = new File("archivo.txt");
    boolean canWrite = file.canWrite();
    System.out.println("¿Se puede escribir en el archivo? " + canWrite);
    ```
