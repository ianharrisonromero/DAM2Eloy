package ascensor_observer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSalaControl {

    private static final int DEFAULT_PORT = 8888;
    // primer split()
    // private static final int RESOURCE_POSITION = 1;
    

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(DEFAULT_PORT);

        while (true) {
            Socket clientConnexion = server.accept();
            Thread thread = new Thread(()-> {
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientConnexion.getInputStream()));
                    String encodedMsg = reader.readLine();
                    String[] decodedMessage = encodedMsg.split(";");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        }
    }
    
}
