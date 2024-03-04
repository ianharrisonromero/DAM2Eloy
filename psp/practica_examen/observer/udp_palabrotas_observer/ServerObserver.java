package udp_palabrotas_observer;

public class ServerObserver implements ObserverPalabrotas {

    @Override
    public void update(String usuario, String palabrota) {
        System.out.println("Palabrota detectada en el mensaje de " + usuario.toUpperCase());
    }

}
