// package servidorUdpPintaCuadrados;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServerUdpCuadrados {

    static final String DESC_MSG = "DESC";
    static final int MAX_LENGTH = (int) (Math.pow(2, 14));
    static int usersCounter = 0;
    static boolean isInteger = false;
    static Integer intMessage = null;
    static String messageBack;
    static int altura;
    static int anchura;
    static char caracter;
    static int port;
    static String ip;

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("ERROR: se necesitan DOS parámetros (IP y puerto)\n");
            return;
        }

        ip = args[0];

        try {
            port = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.err.println("El puerto introducido no es válido (asegurate de que sea un número entero)");
            return;
        }

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
                    try {
                        altura = Integer.parseInt(messageReceived.split(" ")[0]);
                        anchura = Integer.parseInt(messageReceived.split(" ")[1]);
                        caracter = messageReceived.split(" ")[2].charAt(0);
                    } catch (Exception e) {
                        System.err.println("Error al convertir los datos recibidos, deben ser int int char");
                        return;
                    }
                    String messageBack = crearCuadrado(altura, anchura, caracter);

                    System.out.println(" - Preparando cuadrado para devolver: \n" + messageBack);

                    // Create a byte array containing the message to send back
                    byte[] sendData = messageBack.getBytes();

                    // Retrieve the address and port from the received packet IMPORTANTE!!!
                    // -------------------------
                    InetAddress clientAddress = receivedPacket.getAddress();
                    int clientPort = receivedPacket.getPort();

                    // Create a new DatagramPacket to send the data back to the client
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress,
                            clientPort);

                    // Send the packet back to the client
                    socket.send(sendPacket);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static String crearCuadrado(int altura, int anchura, char caracter) {
        String cuadradoTerminado = "";

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                if (i == 0 || i == altura - 1) {
                    cuadradoTerminado += caracter;
                } else {
                    if (j == 0 || j == anchura - 1) {
                        cuadradoTerminado += caracter;

                    } else {
                        cuadradoTerminado += " ";

                    }
                }
            }
            cuadradoTerminado += "\n";
        }

        return cuadradoTerminado;
    }

}
