
// import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerPiramides
 */
public class ServerPiramides {

    public static final int port = 8888;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server listening at port " + port + "\n\n");

            while (true) {

                Socket socket = serverSocket.accept();
                // int clientPort = socket.getPort();
                // InetAddress clientIP = socket.getInetAddress();

                System.out.println("-> Petición recibida del cliente : " + socket);
                System.out.println("-> Lanzando thread para gestionar petición");
                Thread threadPintor = new Thread(new ThreadPintorNc(socket));
                threadPintor.start();

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}