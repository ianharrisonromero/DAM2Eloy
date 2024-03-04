package tcp_leer_fichero_observer;

public class Main {

    private static final String PATH = "fichero.txt";
    static int port = 8000;

    public static void main(String[] args) {

        Server server = new Server(port);
        ObserverLinea observerLinea = new ServerConcreteObserver();
        server.addObserver(observerLinea);

        // thread con lambda thread lambda
        new Thread(() -> {
            server.start();
        }).start();

        Client client = new Client();

        client.sendMessage(PATH, port);

    }

}
