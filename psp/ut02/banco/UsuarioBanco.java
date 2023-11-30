public class UsuarioBanco implements Runnable {

    Object cuenta;
    // boolean bloqueo;
    public static final int N_RETIRADAS = 20;
    public static final int TIMPO_ESPERA = 500;
    public static final int CANTIDAD_A_RETIRAR = 50;

    public UsuarioBanco(Object cuenta) {
        this.cuenta = cuenta;
    }

    // public void ingresar(int CANTIDAD_A_RETIRAR) {
    // MainBanco.saldo += CANTIDAD_A_RETIRAR;
    // System.out.println("Ahora el saldo es de " + MainBanco.saldo);
    // }

    public void retirar(int cantidad) {
        if (MainBanco.saldo >= cantidad) {
            MainBanco.saldo -= cantidad;
            System.out.println(
                    "Retiro OK hecho por : " + Thread.currentThread().getName() + ", saldo ahora es : "
                            + MainBanco.saldo);
        } else {
            System.out.println("no se pudo realizar el retiro. Saldo : " + MainBanco.saldo);
        }
    }

    @Override
    public void run() {

        try {

            Thread.sleep(TIMPO_ESPERA);

            for (int i = 0; i < N_RETIRADAS; i++) {
                synchronized (cuenta) {

                    retirar(CANTIDAD_A_RETIRAR);

                }

                Thread.sleep(TIMPO_ESPERA);

            }
        } catch (Exception e) {
            System.out.println("ERROR: Otro usuario accediendo, espere : ");
        }

    }

}
