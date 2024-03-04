**THREAD LAMBDA**

```java
public class Main3 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread creado usando expresión lambda.");
        });
        thread.start();
    }
}
```
