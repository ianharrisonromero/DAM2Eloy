package ut03.TCP.tcp_doble_puerto;

import java.io.*;
import java.net.*;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class Cliente1DosPuertosTCP {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1";
        final int PORT1 = 12345;

        try {
            Socket socket = new Socket(SERVER_IP, PORT1);
            System.out.println("Connected to Server on port " + PORT1);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // Send data to server
            writer.println("5");
            System.out.println("Sent data to Server: 5");

            // Receive response from server
            String response = reader.readLine();
            System.out.println("Received response from Server: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
