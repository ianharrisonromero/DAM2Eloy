// Crea una clase Counter con un método sincronizado increment que incremente una variable count. 
// Crea dos hilos que incrementen el contador y observa el resultado. Modifica la clase Counter 
// anterior para usar un bloque sincronizado en lugar de un método sincronizado.

// Modificación 04a
// Modifica el ejercicio para poder incrementar y decrementar, crea 5 hilos que incrementen 1000 
// veces y 5 que decrementen 1000 veces. Muestra el resultado de hacer esta operación con sincronización 
// y sin sincornización.

public class SynchronizedCounter {

    public static int counter;
    public static final int NUM_TARGET = 1000;

    // creo objeto de una clase anónima que implementa runnable, y así ahorrar
    // código en la declaración de threads

    // static

    // synchronized mantiene un resultado esperado (2000), sin synchronized no llega
    // a hacerlo (se interrumpen)

    static void increment() {
        counter += 1;
    }

    public static void main(String[] args) {

        Runnable r1 = () -> {
            for (int i = 0; i < NUM_TARGET; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(counter);

        // Thread t1 = new Thread(() -> {
        // for (int i = 0; i < NUM_TARGET; i++) {
        // increment();
        // }
        // });
    }

}