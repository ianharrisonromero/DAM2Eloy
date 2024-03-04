import java.io.*;
import java.net.*;

public class TCPClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public TCPClient(String address, int port, String name) {
        try {
            socket = new Socket(address, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send client name to server
            out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    public void receiveMessages() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter your name: ");
            String name = consoleInput.readLine();
            TCPClient client = new TCPClient("localhost", 9999, name);

            Thread receiveThread = new Thread(client::receiveMessages);
            receiveThread.start();
            System.out.print("Enter message to send (type 'exit' to stop): \n");

            while (true) {
                String message = consoleInput.readLine();
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                client.sendMessage(message);
            }

            client.disconnect();
            receiveThread.join(); // Wait for receive thread to finish
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                consoleInput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
