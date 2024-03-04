package ut03.TCP.tcp_doble_puerto;

import java.io.*;
import java.net.*;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

public class ServerDosPuertosTCP {
    public static void main(String[] args) {
        final int PORT1 = 12345;
        final int PORT2 = 54321;

        try {
            ServerSocket serverSocket1 = new ServerSocket(PORT1);
            ServerSocket serverSocket2 = new ServerSocket(PORT2);

            System.out.println("Server is running...");

            // Client 1 thread
            Thread client1Thread = new Thread(() -> {
                try {
                    while (true) {
                        Socket clientSocket1 = serverSocket1.accept();
                        System.out.println("Client 1 connected.");

                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket1.getOutputStream(), true);

                        String dataFromClient1 = in.readLine();
                        System.out.println("Received from Client 1: " + dataFromClient1);

                        // Process data and prepare response
                        int resultFromClient1 = Integer.parseInt(dataFromClient1) * 2;

                        // Send response to Client 1
                        out.println(resultFromClient1);
                        System.out.println("Sent result to Client 1: " + resultFromClient1);

                        clientSocket1.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Client 2 thread
            Thread client2Thread = new Thread(() -> {
                try {
                    while (true) {
                        Socket clientSocket2 = serverSocket2.accept();
                        System.out.println("Client 2 connected.");

                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket2.getOutputStream(), true);

                        String dataFromClient2 = in.readLine();
                        System.out.println("Received from Client 2: " + dataFromClient2);

                        // Process data and prepare response
                        int resultFromClient2 = Integer.parseInt(dataFromClient2) + 5;

                        // Send response to Client 2
                        out.println(resultFromClient2);
                        System.out.println("Sent result to Client 2: " + resultFromClient2);

                        clientSocket2.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Start both client threads
            client1Thread.start();
            client2Thread.start();

            // Wait for both threads to finish
            client1Thread.join();
            client2Thread.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

