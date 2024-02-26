import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private TCPServer server;
    private String clientName;
    private int clientId;

    public ClientHandler(Socket socket, TCPServer server, String clientName, int clientId) {
        this.socket = socket;
        this.server = server;
        this.clientName = clientName;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message;
            while ((message = in.readLine()) != null) {
                server.update(clientName + ": " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.removeClient(clientId);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
