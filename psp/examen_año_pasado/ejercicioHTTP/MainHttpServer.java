package examen_año_pasado.ejercicioHTTP;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MainHttpServer {

    private static final int NUM_ARGS = 1;
    public static String ip = "localhost";
    public static int port;
    private static final int RESOURCES_NUMBER = 2;
    private static final int FIRST_RESOURCE_POSITION = 1;
    private static final int SECOND_RESOURCE_POSITION = 2;

    public static void main(String[] args) {
        if (args.length != NUM_ARGS) {
            System.out.println("ERROR: 1 argument spected (port)");
            return;
        }

        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("ERROR en parseo, asegúrate de introducir un integer (puerto)");
            return;
        }

        PrimoObserver observador = new Logger();
        PrimosSearcher.addObserver(observador);

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String header = reader.readLine();
                System.out.println("Request Header: " + header);
                String[] info = extractInfo(header);
                int n, m;
                try {
                    n = Integer.parseInt(info[FIRST_RESOURCE_POSITION]);
                    m = Integer.parseInt(info[SECOND_RESOURCE_POSITION]);
                    Thread t = new Thread(new PrimosSearcher(clientSocket, n, m));
                    t.start();

                } catch (Exception e) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // CUIDADO AQUI PUEDE HABER ERROR, EN EL SUBSTRING
    private static String[] extractInfo(String header) {
        String[] parts = header.split(" ")[FIRST_RESOURCE_POSITION].split("/");
        return parts; // Remove leading "/"
        /*
         * if (parts.length > RESOURCES_NUMBER) {
         * return parts; // Remove leading "/"
         * } else {
         * return parts[0] = "index.html"; // Default to index.html if no specific
         * resource requested
         * }
         */
    }

}
