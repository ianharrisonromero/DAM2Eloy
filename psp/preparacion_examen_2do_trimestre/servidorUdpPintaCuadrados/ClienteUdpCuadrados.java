// package servidorUdpPintaCuadrados;

import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClienteUdpCuadrados {

    static final String DESC_MSG = "DESC";
    static final int MAX_LENGTH = (int) (Math.pow(2, 14));
    static int usersCounter = 0;
    static boolean isInteger = false;
    static Integer intMessage = null;
    static String messageBack;
    static int port;
    static String ip;
    public static final int ARGS_NUM = 2;

    public static void main(String[] args) {

        if (args.length != ARGS_NUM) {
            System.out.println("ERROR: se necesitan DOS parámetros (IP y puerto)\n");
            return;
        }

        ip = args[0];

        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException nf) {
            System.err.println("El puerto introducido no es válido (asegurate de que sea un número entero)");
            return;
        } /*
           * catch (SocketException se) {
           * System.err.println("ERROR EN EL SOCKET");
           * }
           */

        try {
            while (true) {
                DatagramSocket socket = new DatagramSocket(); // Abre el socket en el puerto XXXX

                Scanner sc = new Scanner(System.in);
                System.out.println("Introduce, separado por espacios : {int altura} {int anchura} {char caracter}");
                String mensajeEnviar = sc.nextLine();
                // ABRIR SOCKET Y CREAR DATA DE BYTES
                InetAddress ipAddress = InetAddress.getByName(ip); // Dirección del servidor
                byte[] dataEnviar = new byte[MAX_LENGTH];
                dataEnviar = mensajeEnviar.getBytes();

                // ENVIAR
                DatagramPacket sendPacket = new DatagramPacket(dataEnviar, dataEnviar.length, ipAddress, port);
                socket.send(sendPacket); // Envía el paquete al servidor

                // RECIBIR
                byte[] receivedData = new byte[MAX_LENGTH];
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                socket.receive(receivedPacket); // Espera y recibe el paquete

                // Extrae la información del paquete
                String messageReceived = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println(messageReceived);
                // sc.close(); <-- ESTO JAMAS
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
