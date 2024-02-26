import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*Implement a UDP server that listens for incoming messages.
Upon receiving a message, the server will determine its type:
If the message is a number, the server will check if it is prime and respond accordingly.
If the message is a string, the server will count the number of words, vowels, and consonants 
and respond with the counts.
The server should be capable of handling multiple clients simultaneously.
Implement error handling for invalid inputs. */

public class ServidorPrimosStrings {

  String ip;
  static Integer port = 8000;
  String msg;
  static final String DESC_MSG = "DESC";
  static final int MAX_LENGTH = (int) (Math.pow(2, 14));
  static int usersCounter = 0;
  static boolean isInteger = false;
  static Integer intMessage = null;
  static String messageBack;
  static int[] counts;

  public static void main(String[] args) {
    try {
      DatagramSocket socket = new DatagramSocket(port); // Abre el socket en el puerto 8000

      while (true) {
        System.out.println("Servidor en puerto 8000 listo para recibir:\n");
        intMessage = null;
        isInteger = false;
        messageBack = "";
        byte[] receivedData = new byte[MAX_LENGTH];
        DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
        socket.receive(receivedPacket); // Espera y recibe el paquete
        // tiene sentido que si hubiera THREAD fuera AQUÍ (JUSTO DESPUÉS DE ACCIÓN BLOQUEANTE)

        // Extrae la información del paquete
        String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());

        try {
          intMessage = Integer.parseInt(message);
          isInteger = true;
          System.out.println("- Integer recibido : " + message);
        } catch (Exception e) {
          System.out.println("- Not an integer");
          System.out.println("Mensaje recibido : " + message);
        }

        if (isInteger) {
          if (isPrime(intMessage)) {
            messageBack = "El número " + intMessage + " es primo";
          } else {
            messageBack = "El número " + intMessage + " no es primo";
          }
        } else {
          counts = countWordsVowelsAndConsonants(message);
          messageBack = "La cadena contiene " + counts[0] + " palabras, " + counts[1] + " vocales y " + counts[2]
              + " consonantes.";
        }

        try {
          System.out.println("- Preparando mensaje para devolver : " + messageBack);
          // Create a byte array containing the message to send back
          byte[] sendData = messageBack.getBytes();

          // Retrieve the address and port from the received packet IMPORTANTE!!! -------------------------
          InetAddress clientAddress = receivedPacket.getAddress();
          int clientPort = receivedPacket.getPort();

          // Create a new DatagramPacket to send the data back to the client
          DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);

          // Send the packet back to the client
          socket.send(sendPacket);
        } catch (Exception e) {
          // TODO: handle exception
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static boolean isPrime(int number) {
    if (number <= 1) {
      return false;
    }
    if (number <= 3) {
      return true;
    }
    if (number % 2 == 0 || number % 3 == 0) {
      return false;
    }
    for (int i = 5; i * i <= number; i = i + 6) {
      if (number % i == 0 || number % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }

  public static int[] countWordsVowelsAndConsonants(String str) {
    int[] counts = new int[3]; // Index 0 for words, index 1 for vowels, index 2 for consonants
    str = str.toLowerCase(); // Convert the string to lowercase for case-insensitive comparison

    // Count words
    String[] words = str.split("\\s+");
    counts[0] = words.length;

    // Count vowels and consonants
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      // Check if the character is a vowel
      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        counts[1]++; // Increment vowel count
      } else if (ch >= 'a' && ch <= 'z') {
        counts[2]++; // Increment consonant count
      }
    }
    return counts;
  }
}
