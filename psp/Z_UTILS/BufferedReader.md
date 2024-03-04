**IMPORTANTE: EL .WRITE NECESITA UN `flush()` DESPUES DE ESCRIBIR**

**IMPORTANTE: EL SEGUNDO ARGUMENTO DE DEL FileWriter es APPEND (BOOLEAN)**

**FilerWriter**:

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
´´´

**FilerReaderr**:

```java
import java.io.FileReader;
