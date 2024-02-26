import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClientePrimosStrings {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final int MAX_LENGTH = (int) (Math.pow(2, 14));
    String ip = "localhost";
    Integer port = 8000;
    String sentence = "";

    while (true) {
      try {
        System.out.println("-Introduce una string o un int:");
        sentence = sc.nextLine(); // Mensaje a enviar

        if (sentence.trim().isEmpty()) {
          System.out.println("ERROR: Mensaje vacío");
          continue;
        }

        DatagramSocket socket = new DatagramSocket();
        InetAddress ipAddress = InetAddress.getByName(ip); // Dirección del servidor
        byte[] sentData = new byte[MAX_LENGTH];
        sentData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sentData, sentData.length, ipAddress, port);
        socket.send(sendPacket); // Envía el paquete al servidor

        byte[] receivedData = new byte[MAX_LENGTH];
        DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
        socket.receive(receivedPacket);
        String messageReceived = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
        System.out.println("RECIBIDO : " + messageReceived);

      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    // Desconexión
    // try {
    // DatagramSocket socket = new DatagramSocket();
    // InetAddress ipAddress = InetAddress.getByName(ip); // Dirección del servidor
    // byte[] sentData = new byte[MAX_LENGTH];
    // sentence = ServidorPrimosStrings.DESC_MSG; // Mensaje a enviar ("DESC")

    // String encodedSentence = username + ";" + sentence;

    // sentData = encodedSentence.getBytes();

    // DatagramPacket sendPacket = new DatagramPacket(
    // sentData,
    // sentData.length,
    // ipAddress,
    // port);
    // socket.send(sendPacket); // Envía el paquete al servidor
    // socket.close();
    // return;
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
  }
}
