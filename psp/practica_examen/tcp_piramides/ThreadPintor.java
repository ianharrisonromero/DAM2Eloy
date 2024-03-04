import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.Socket;

public class ThreadPintor implements Runnable {

    public Socket socket;
    // public InetAddress clientIP;
    // public int clientPort;

    public ThreadPintor(Socket socket) {
        this.socket = socket;
        // this.clientPort = clientPort;
        // this.clientIP = clientIP;
    }

    @Override
    public void run() {
        try {
            DataInputStream clientInput = new DataInputStream(socket.getInputStream());
            String messageReceived = clientInput.readUTF();
            String messageBack = "";
            int altura = 0;

            try {
                altura = Integer.parseInt(messageReceived);
            } catch (Exception e) {
                messageBack = "ERROR : no se hizo el parseo correcto o el input es inválido";
            }

            messageBack = createPiramid(altura);

            sendBackToClient(messageBack, socket);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private void sendBackToClient(String piramide, Socket socket) {
        try {
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
            outToClient.writeUTF(piramide);
            socket.close();
        } catch (Exception e) {
            // Manejar excepciones adecuadamente
        }
    }

    private String createPiramid(int altura) {
        String piramid = "";

        for (int i = 0; i < altura; i++) {
            // Adding spaces in front of numbers
            for (int j = 0; j < altura - i - 1; j++) {
                piramid += " ";
            }

            // Printing numbers
            for (int k = 0; k <= i; k++) {
                piramid += "* ";
            }

            piramid += "\n";
        }
        return piramid;

    }

}
