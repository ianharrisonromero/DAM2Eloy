import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ThreadPintor implements Runnable {

    public Socket clientSocket;

    public ThreadPintor(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public ThreadPintor(Socket clientSocket2, int clientPort, Object clientIPt) {
    }

    @Override
    public void run() {
        try {
            DataInputStream clientInput = new DataInputStream(clientSocket.getInputStream());
            String messageReceived = clientInput.readUTF();
            String messageBack = "";
            int altura = 0;

            try {
                altura = Integer.parseInt(messageReceived);
            } catch (Exception e) {
                messageBack = "ERROR : no se hizo el parseo correcto o el input es inválido";
            }

            messageBack = createPiramid(altura);

            sendBackToClient(messageBack);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private void sendBackToClient(String piramide) {
        try {
            Socket socket = new Socket(clientSocket.getInetAddress(), clientSocket.getPort());
            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
            outToClient.writeUTF(piramide);
            socket.close();
        } catch (Exception e) {
        }

    }

    private String createPiramid(int altura) {
        String piramid = "";

        for (int i = 0; i < altura; i++) {
            // Adding spaces in front of numbers
            for (int j = 0; j < altura - i - 1; j++) {
                System.out.print(" ");
            }

            // Printing numbers
            for (int k = 0; k <= i; k++) {
                System.out.print("* ");
            }

        }
        return piramid;

    }

}
