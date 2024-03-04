package ut03.UDP.udp_doble_puerto;

import java.net.*;

public class UDPClient1 {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1";
        final int SERVER_PORT = 12345;

        try {
            DatagramSocket socket = new DatagramSocket();

            String message = "10"; // Datos enviados por el Cliente 1
            byte[] sendData = message.getBytes();

            // Envía datos al servidor
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(SERVER_IP),
                    SERVER_PORT);
            socket.send(sendPacket);
            System.out.println("Message sent from Client 1: " + message);

            // Recibe respuesta del servidor
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Result received from Server by Client 1: " + result);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
