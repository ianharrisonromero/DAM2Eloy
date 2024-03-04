package udp_palabrotas_observer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;

public class Server {

    String ip;
    static Integer port = 8000;
    String msg;
    static final String DESC_MSG = "DESC";
    static final int MAX_LENGTH = (int) (Math.pow(2, 14));
    static Map<Integer, String> userMap = new HashMap<>();
    static List<String> listaPalabrotas = new ArrayList<>();
    static private List<ObserverPalabrotas> observers = new ArrayList<>();
    static int usersCounter = 0;

    public static void main(String[] args) {

        listaPalabrotas.add("zorra");
        listaPalabrotas.add("puta");
        listaPalabrotas.add("cabrón");
        listaPalabrotas.add("cabron");
        listaPalabrotas.add("hijo de puta");
        listaPalabrotas.add("hija de puta");

        ObserverPalabrotas serverObserver = new ServerObserver();
        observers.add(serverObserver);
        Server server = new Server();

        try {
            DatagramSocket socket = new DatagramSocket(port); // Abre el socket en el puerto 8000
            byte[] receivedData = new byte[MAX_LENGTH];

            System.out.println("servidor esperando en el puerto " + port);

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(
                        receivedData,
                        receivedData.length);
                socket.receive(receivedPacket); // Espera y recibe el paquete

                new Thread(() -> {
                    // Extrae la información del paquete
                    String message = new String(
                            receivedPacket.getData(),
                            0,
                            receivedPacket.getLength());
                    String[] decodedMessage = message.split(";");

                    if (decodedMessage[0].equals("")) {
                        decodedMessage[0] = "GUEST";
                        System.out.println(decodedMessage[0] + " se ha conectado.");

                    } else {
                        userMap.put(usersCounter, decodedMessage[0]);
                        usersCounter++;
                        System.out.println(decodedMessage[0] + " se ha conectado.");
                    }

                    for (String palabrota : listaPalabrotas) {
                        if (decodedMessage[1].toLowerCase().contains(palabrota)) {

                            server.notifyServerObservers(decodedMessage[0], palabrota);
                            // Aquí puedes tomar acciones adicionales,
                            // como enviar una advertencia o
                            // bloquear al usuario
                            continue; // Si se detecta una palabrota, no es necesario seguir verificando las demás
                        }
                    }

                    try {
                        if (decodedMessage[1].equals(DESC_MSG)) {
                            System.out.println(
                                    decodedMessage[0].toUpperCase() + " se ha desconectado.");
                        } else {
                            System.out.println(
                                    decodedMessage[0].toUpperCase() + ": " + decodedMessage[1]);
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addObserver(ObserverPalabrotas observer) {
        observers.add(observer);
    }

    public void removeObserver(ObserverPalabrotas observer) {
        observers.remove(observer);
    }

    private void notifyServerObservers(String usuario, String palabrota) {
        for (ObserverPalabrotas observer : observers) {
            observer.update(usuario, palabrota);
        }
    }
}
