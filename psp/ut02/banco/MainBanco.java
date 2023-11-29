public class MainBanco {

    static Object cuenta = new Object();
    static int saldo = 1000;

    public static void main(String[] args) {

        Thread tAlice = new Thread(new UsuarioBanco(MainBanco.cuenta), "Alice");
        Thread tBob = new Thread(new UsuarioBanco(MainBanco.cuenta), "Bob");

        tAlice.start();
        tBob.start();

    }
}
