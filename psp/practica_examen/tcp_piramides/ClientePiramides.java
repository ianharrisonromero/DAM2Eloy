import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientePiramides {

    private static final int NUM_ARGS = 1;
    public static int altura;
    public static String ip = "localhost";
    public static int port = 8000;

    public static void main(String[] args) {
        if (args.length != NUM_ARGS) {
            System.out.println("ARGS NUM INVALID, HAS TO BE 1 INT NUMBER");
            return;
        }

        try {
            altura = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("ERROR en parseo, asegúrate de introducir un integer");
            return;
        }

        try {
            Socket socket = new Socket(ip, port);
            // IN AND OUT
            DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
            DataInputStream inFromServer = new DataInputStream(socket.getInputStream());

            String alturaString = String.valueOf(altura);
            outToServer.writeUTF(alturaString);

            // Read response from server
            String response = inFromServer.readUTF();
            System.out.println("\nResponse from server: \n\n" + response);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
