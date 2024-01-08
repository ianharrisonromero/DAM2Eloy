import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

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

public class server1 {

    private static final int MAX_LENGTH = 65535;

    public static void main(String[] args) {

        Integer port = null;

        if (args.length != 1) {
            System.out.println("ERROR: se necesita un parámetro (puerto)\n");
            return;
        }

        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            DatagramSocket socket = new DatagramSocket(port); // Abre el socket en el puerto XXXX
            byte[] receivedData = new byte[MAX_LENGTH];

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                socket.receive(receivedPacket); // Espera y recibe el paquete

                // Extrae la información del paquete
                String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println("Mensaje recibido: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}