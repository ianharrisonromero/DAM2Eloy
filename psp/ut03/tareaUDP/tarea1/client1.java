import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class client1 {

    /**
     * Tarea 1: Ejemplo simple
     * 
     * Crea un programa servidor que reciba por parámetro un número que representa
     * el puerto en el que escuchará, cuando reciba un mensaje lo escribirá por
     * pantalla.
     * Crea un programa cliente que reciba por parámetro una cadena representando la
     * dirección ip, un número representando el puerto y una última cadena
     * representando el texto a enviar. El programa enviará la información usando
     * UDP.
     */

    private static final int MAX_LENGTH = 65535;

    public static void main(String[] args) {

        Integer port = null;

        if (args.length != 3) {
            System.out.println("ERROR: se necesitan tres parámetros (IP, puerto y mensaje)\n");
            return;
        }

        try {
            port = Integer.parseInt(args[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress ipAddress = InetAddress.getByName(args[0]);
            byte[] sendData = new byte[MAX_LENGTH];
            String sentence = args[2]; // Mensaje a enviar
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
            socket.send(sendPacket); // Envía el paquete al servidor
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
