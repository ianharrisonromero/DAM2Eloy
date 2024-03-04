package ut03.UDP.udp_doble_puerto;

import java.net.*;

public class ServerDosPuertosUDP {
    public static void main(String[] args) {
        final int PORT1 = 12345;
        final int PORT2 = 54321;

        try {
            DatagramSocket socket1 = new DatagramSocket(PORT1);
            DatagramSocket socket2 = new DatagramSocket(PORT2);

            System.out.println("Server is running...");

            // Client 1 thread
            Thread client1Thread = new Thread(() -> {
                try {
                    while (true) {
                        byte[] buffer = new byte[1024];

                        // Receive from Client 1
                        DatagramPacket packetFromClient1 = new DatagramPacket(buffer, buffer.length);
                        socket1.receive(packetFromClient1);
                        String dataFromClient1 = new String(packetFromClient1.getData()).trim();
                        System.out.println("Received from Client 1: " + dataFromClient1);

                        // Process data and prepare response
                        int resultFromClient1 = Integer.parseInt(dataFromClient1) * 2;

                        // Send response to Client 1
                        byte[] responseData1 = String.valueOf(resultFromClient1).getBytes();
                        DatagramPacket responsePacket1 = new DatagramPacket(responseData1, responseData1.length,
                                packetFromClient1.getAddress(), packetFromClient1.getPort());
                        socket1.send(responsePacket1);
                        System.out.println("Sent result to Client 1: " + resultFromClient1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // Client 2 thread
            Thread client2Thread = new Thread(() -> {
                try {
                    while (true) {
                        byte[] buffer = new byte[1024];

                        // Receive from Client 2
                        DatagramPacket packetFromClient2 = new DatagramPacket(buffer, buffer.length);
                        socket2.receive(packetFromClient2);
                        String dataFromClient2 = new String(packetFromClient2.getData()).trim();
                        System.out.println("Received from Client 2: " + dataFromClient2);

                        // Process data and prepare response
                        int resultFromClient2 = Integer.parseInt(dataFromClient2) + 5;

                        // Send response to Client 2
                        byte[] responseData2 = String.valueOf(resultFromClient2).getBytes();
                        DatagramPacket responsePacket2 = new DatagramPacket(responseData2, responseData2.length,
                                packetFromClient2.getAddress(), packetFromClient2.getPort());
                        socket2.send(responsePacket2);
                        System.out.println("Sent result to Client 2: " + resultFromClient2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // Start both client threads
            client1Thread.start();
            client2Thread.start();

            // Wait for both threads to finish
            client1Thread.join();
            client2Thread.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
