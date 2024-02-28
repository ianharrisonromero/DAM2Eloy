import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerPiramides
 */
public class ServerPiramides {

    public static final int port = 8000;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server listening at port " + port + "\n\n");

            while (true) {

                Socket clientSocket = serverSocket.accept();
                int clientPort = clientSocket.getPort();
                InetAddress clientIP = clientSocket.getInetAddress();

                System.out.println("-> Petición recibida del cliente : " + clientSocket);
                System.out.println("-> Lanzando thread para realizar petición");;
                Thread threadPintor = new Thread(new ThreadPintor(clientSocket, clientPort, clientIP));
                threadPintor.start();

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}