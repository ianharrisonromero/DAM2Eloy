package udp_reclutas_broadcast;

public class ConcreteObserver implements BajasObserver {

    @Override
    public void update(String mensaje) {
        System.out.println(mensaje);
    }

}
