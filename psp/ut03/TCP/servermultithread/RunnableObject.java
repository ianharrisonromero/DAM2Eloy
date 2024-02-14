
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RunnableObject implements Runnable {

  Socket socket;

  public RunnableObject(Socket socket) {
    socket = this.socket;
  }

  @Override
  public void run() {
    try {
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      String s = in.readLine();
      for (int x = 0; x < 32000; x++) {
        for (int i = 0; i < 1000; i++) {
          out.writeUTF(x + s.toUpperCase());
        }
      }

      in.close();
      out.close();
      socket.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
