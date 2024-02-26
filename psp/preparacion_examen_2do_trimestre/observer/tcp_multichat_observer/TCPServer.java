import java.io.*;
import java.net.*;

public class TCPServer implements MessageObserver {
    private ServerSocket serverSocket;
    private PrintWriter[] clientWriters;
    private String[] clientNames;

    public TCPServer(int port, int maxClients) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started. Waiting for clients...");
            clientWriters = new PrintWriter[maxClients];
            clientNames = new String[maxClients];
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void acceptClients() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();

                int clientId = findNextAvailableClientId();
                if (clientId != -1) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    clientNames[clientId] = reader.readLine(); // Read client name
                    ClientHandler clientHandler = new ClientHandler(socket, this, clientNames[clientId], clientId);
                    clientWriters[clientId] = new PrintWriter(socket.getOutputStream(), true);
                    new Thread(clientHandler).start();
                } else {
                    System.out.println("Max clients reached. Rejecting new connection.");
                    socket.close();
                }

                System.out.println("Client connected: " + socket + "[ID : " + clientId + "][NAME : "
                        + clientNames[clientId] + "]");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int findNextAvailableClientId() {
        for (int i = 0; i < clientWriters.length; i++) {
            if (clientWriters[i] == null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(String message) {
        System.out.println("Received message from client: " + message);
        broadcast(message);
    }

    public void broadcast(String message) {
        for (int i = 0; i < clientWriters.length; i++) {
            if (clientWriters[i] != null) {
                clientWriters[i].println(message);
            }
        }
    }

    public void removeClient(int clientId) {
        clientWriters[clientId] = null;
    }

    public static void main(String[] args) {
        final int MAX_CLIENTS = 10; // Maximum number of clients
        TCPServer server = new TCPServer(9999, MAX_CLIENTS);
        server.acceptClients();
    }
}
