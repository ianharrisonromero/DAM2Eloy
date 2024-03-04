package tcp_doble_puerto;

import java.io.*;
import java.net.*;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Cliente2DosPuertosTCP {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1";
        final int PORT2 = 54321;

        try {
            Socket socket = new Socket(SERVER_IP, PORT2);
            System.out.println("Connected to Server on port " + PORT2);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send data to server
            writer.println("10");
            System.out.println("Sent data to Server: 10");

            // Receive response from server
            String response = reader.readLine();
            System.out.println("Received response from Server: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
