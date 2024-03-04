import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatClient {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final int MAX_LENGTH = (int) (Math.pow(2, 14));
    String username;
    String ip = "localhost";
    Integer port = 8000;
    System.out.println("Introduce tu nombre:\n");
    username = sc.nextLine();
    String msg = "Hola soy, " + username;

    while (!msg.trim().isEmpty()) {
      try {
        DatagramSocket socket = new DatagramSocket();
        InetAddress ipAddress = InetAddress.getByName(ip); // Dirección del servidor
        byte[] sentData = new byte[MAX_LENGTH];
        sentData = msg.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(
            sentData,
            sentData.length,
            ipAddress,
            port);
        socket.send(sendPacket); // Envía el paquete al servidor

        while (!msg.trim().isEmpty()) {
          String sentence = sc.nextLine(); // Mensaje a enviar

          if (sentence.trim().isEmpty()) {
            break;
          }

          if (sentence.equals("DESC")) {
            break;
          }

          String encodedMessage = username + ";" + sentence;
          sentData = encodedMessage.getBytes();

          sendPacket = new DatagramPacket(sentData, sentData.length, ipAddress, port);
          socket.send(sendPacket); // Envía el paquete al servidor
          // socket.close(); // CREO QUE ESTE ERA EL PROBLEMA
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    // Desconexión
    try {
      DatagramSocket socket = new DatagramSocket();
      InetAddress ipAddress = InetAddress.getByName(ip); // Dirección del servidor
      byte[] sentData = new byte[MAX_LENGTH];
      String sentence = ChatServer.DESC_MSG; // Mensaje a enviar ("DESC")

      String encodedSentence = username + ";" + sentence;

      sentData = encodedSentence.getBytes();

      DatagramPacket sendPacket = new DatagramPacket(
          sentData,
          sentData.length,
          ipAddress,
          port);
      socket.send(sendPacket); // Envía el paquete al servidor
      socket.close();
      return;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
