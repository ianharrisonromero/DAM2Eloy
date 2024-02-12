import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ClienteMandaString {

  public static void main(String[] args) {
    try {
      Socket socket = new Socket("127.0.0.1", 1234);
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      out.writeUTF("Hola mundo de los sockets!!!\n");
      out.flush(); // Make sure all data is sent
      BufferedReader in = new BufferedReader(
        new InputStreamReader(socket.getInputStream())
      );
      String response;
      while ((response = in.readLine()) != null) {
        System.out.println(response);
      }
      //   System.out.println(in.readLine());
      in.close();
      out.close();
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
