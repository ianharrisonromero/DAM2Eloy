##IO

**IMPORTANTE: EL .WRITE NECESITA UN `flush()` DESPUES DE ESCRIBIR**

**IMPORTANTE: EL SEGUNDO ARGUMENTO DE DEL FileWriter es APPEND (BOOLEAN)**

1.  **FileReader**:

    ```java
    StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(info))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "<html><body><h1>Error 500: Internal Server Error</h1></body></html>";
        }
    ```

2.  **FileWriter**:

    ```java
    import java.io.FileWriter;


    String log = "\nPRIMO ENCONTRADO : " + primo + "\n";
            System.out.println(log);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true)); // true para hacer append
                writer.write(log);
                writer.write("\n-------------------------------\n");
                writer.flush(); //IMPORTANTE
            } catch (Exception e) {
                e.printStackTrace();
            }

    ```

3.  **InputStreamReader/Writer**
        ```java
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    ´´´
