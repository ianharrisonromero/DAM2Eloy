// package servidorUdpPintaCuadrados;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
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
    static int port = 8000;
    static String ip = "localhost";

    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(port);// Abre el socket en el puerto XXXX
            while (true) {
                try {
                    byte[] receivedData = new byte[MAX_LENGTH];
                    DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                    socket.receive(receivedPacket); // Espera y recibe el paquete

                    // Extrae la información del paquete
                    String messageReceived = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                    System.out.println("Mensaje recibido: " + messageReceived);

                    Integer numAleatorio = rand.nextInt(MAX_ALEATORIO) + MIN_ALEATORIO;
                    String numAleatorioString = numAleatorio.toString();

                    byte[] sendData = numAleatorioString.getBytes();

                    // Retrieve the address and port from the received packet IMPORTANTE!!!
                    // -------------------------
                    InetAddress clientAddress = receivedPacket.getAddress();
                    int clientPort = receivedPacket.getPort();

                    // Create a new DatagramPacket to send the data back to the client
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress,
                            clientPort);

                    // Send the packet back to the client
                    socket.send(sendPacket);
                    // Thread.sleep(ONE_SEC);

                    // Create a byte array containing the message to send back

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
