import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorBroadcast {
    /*
     * dos clases, una cliente envía una cadena y espera respuesta, y otra servidor
     * que hace eco
     * (un while true en el servidor, y a esa dirección ip responde con la misma
     * cadena, y con
     * un log con "he recibido esto:"
     * SABER DE QUIÉN RECIBES PARA SABER DÓNDE MANDAR (método en datagramSocket))
     */

    private static final int MAX_LENGTH = 65535;
    private static final int PORT = 8000;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT); // Abre el socket en el puerto 9876
            byte[] receivedData = new byte[MAX_LENGTH];

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                socket.receive(receivedPacket); // Espera y recibe el paquete

                // Extrae la información del paquete
                String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println("Mensaje recibido de " + receivedPacket.getAddress() + ":" + receivedPacket.getPort()
                        + " -Mensaje: " + message);
                System.out.println("_________________________\n");
                // creamo s otra cadena de bytes y otro paquete para enviarlo de vuelta
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivedPacket.getAddress(),
                        receivedPacket.getPort());
                // enviar de vuelta
                socket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
