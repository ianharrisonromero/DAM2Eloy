package tcp_leer_fichero_observer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// package servidorUdpPintaCuadrados;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Server {

    static final String DESC_MSG = "DESC";
    static final int MAX_LENGTH = (int) (Math.pow(2, 14));
    public static final int MIN_ALEATORIO = 1;
    public static final int MAX_ALEATORIO = 100;
    public static final long ONE_SEC = 1000l;
    static Random rand = new Random();
    static int usersCounter = 0;
    static boolean isInteger = false;
    static Integer intMessage = null;
    static String messageBack;
    static int altura;
    static int anchura;
    static char caracter;
    public int port = 8000;
    static String ip = "localhost";
    static String linea = "";
    private List<ObserverLinea> observers = new ArrayList<>();

    public Server(int port) {
        this.port = port;
    }

    public void start() {

        try {
            DatagramSocket socket = new DatagramSocket(port);// Abre el socket en el puerto XXXX
            while (true) {
                try {
                    byte[] receivedData = new byte[MAX_LENGTH];
                    DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                    socket.receive(receivedPacket); // Espera y recibe el paquete
                    System.out.println("SERVER: listo en : " + socket);

                    // Extrae la información del paquete
                    String pathReceived = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                    System.out.println("Mensaje recibido: " + pathReceived);

                    try (BufferedReader reader = new BufferedReader(new FileReader(pathReceived))) {
                        linea = "";
                        while ((linea = reader.readLine()) != null) {
                            try {
                                Thread.sleep(ONE_SEC);
                            } catch (Exception e) {
                                // TODO: handle exception
                            }

                            notifyObservers();

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public void addObserver(ObserverLinea observer) {
        observers.add(observer);
    }

    public void removeObserver(ObserverLinea observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (ObserverLinea observer : observers) {
            observer.update(linea);
        }
    }

}
