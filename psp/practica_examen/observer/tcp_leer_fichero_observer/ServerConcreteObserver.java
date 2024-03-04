package tcp_leer_fichero_observer;

public class ServerConcreteObserver implements ObserverLinea {
    @Override
    public void update(String linea) {
        System.out.println("Nueva Línea !! : " + linea);
    }
}
