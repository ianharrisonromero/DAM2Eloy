package udp_reclutas_broadcast;

import java.util.Scanner;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

    static int inPort = 8000;
    static int outPort = 9000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX_LENGTH = (int) (Math.pow(2, 14));
        String ip = "192.168.63.33";
        String sentence = "";

        new Thread(() -> {
            try {
                DatagramSocket socket = new DatagramSocket(inPort);
                byte[] receivedData = new byte[MAX_LENGTH];
                socket.setBroadcast(true);
                while (true) {
                    DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                    socket.receive(receivedPacket);

                    String messageReceived = new String(receivedPacket.getData(), 0,
                            receivedPacket.getLength());
                    System.out.println("MENSAJE RECIBIDO DESDE LA CENTRAL : " + messageReceived);
                }

            } catch (Exception e) {
                // TODO: handle exception
            }

        }).start();

        // Mensaje a enviar
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ipAddress = InetAddress.getByName(ip); // Dirección del servidor
            byte[] sentData = new byte[MAX_LENGTH];

            while (true) {
                System.out.println("-Introduce un mensaje (Formato: 'ALTAS/BAJAS NUM_BAJAS')");
                sentence = sc.nextLine();
                sentData = sentence.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sentData, sentData.length, ipAddress, outPort);
                socket.send(sendPacket); // Envía el paquete al servidor
            }
        } catch (Exception e) {

        }

    }
}