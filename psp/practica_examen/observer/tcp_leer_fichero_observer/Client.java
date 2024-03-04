package tcp_leer_fichero_observer;

import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Client {

    static final String DESC_MSG = "DESC";
    static final int MAX_LENGTH = (int) (Math.pow(2, 14));
    static int usersCounter = 0;
    static boolean isInteger = false;
    static Integer intMessage = null;
    static String messageBack;
    static String ip = "localhost";
    public static final int ARGS_NUM = 2;
    public static final long ONE_SEC = 1000l;
    public String path;
    static int port;

    public void sendMessage(String path, int port) {

        try {
            DatagramSocket socket = new DatagramSocket(); // Abre el socket en el puerto XXXX

            // ABRIR SOCKET Y CREAR DATA DE BYTES
            InetAddress ipAddress = InetAddress.getByName(ip); // Dirección del servidor
            byte[] dataEnviar = new byte[MAX_LENGTH];
            dataEnviar = path.getBytes();

            // ENVIAR
            DatagramPacket sendPacket = new DatagramPacket(dataEnviar, dataEnviar.length, ipAddress, port);
            socket.send(sendPacket); // Envía el paquete al servidor

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
