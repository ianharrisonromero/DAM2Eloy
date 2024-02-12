import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

public class ServerMultithread {

  public static void main(String[] args) {
    ServerSocket serverSocket;

    try {
      serverSocket = new ServerSocket(1234);
      while (true) {
        // Espera cliente
        Socket socket = serverSocket.accept();
        Thread thread = new Thread(new RunnableObject(socket));
        thread.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
