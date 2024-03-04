```java
// 1. Creación de Thread extendiendo la clase Thread
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread creado extendiendo la clase Thread.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}

// 2. Creación de Thread implementando la interfaz Runnable
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread creado implementando la interfaz Runnable.");
    }
}

public class Main2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}

// 3. Creación de Thread usando expresión lambda
public class Main3 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Thread creado usando expresión lambda.");
        });
        thread.start();
    }
}
``````