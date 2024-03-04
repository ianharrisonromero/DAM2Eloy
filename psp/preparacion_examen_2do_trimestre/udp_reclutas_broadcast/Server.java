package udp_reclutas_broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Server {

    static final String DESC_MSG = "DESC";
    static final int MAX_LENGTH = (int) (Math.pow(2, 14));
    private static final long ONE_MINUTE = 60000;
    static int usersCounter = 0;
    static boolean isInteger = false;
    static Integer intMessage = null;
    static String messageBack;
    static int altura;
    static int anchura;
    static char caracter;
    static int inPort = 8000;
    static int outPort = 9000;
    static String ip;
    static long soldiersCount = 80_000;

    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(inPort);// Abre el socket en el puerto XXXX
            byte[] receivedData = new byte[MAX_LENGTH];

            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(ONE_MINUTE);
                    } catch (Exception e) {
                    }
                    String reporte = getReporte(getSoldiersCount());
                    sendBroadcast(reporte);
                }
            });

            while (true) {
                try {
                    DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                    socket.receive(receivedPacket); // Espera y recibe el paquete

                    try {
                        new Thread(() -> {
                            // Extrae la información del paquete
                            String messageReceived = new String(receivedPacket.getData(), 0,
                                    receivedPacket.getLength());
                            System.out.println("Mensaje recibido: " + messageReceived);

                            // extraer INFO
                            String[] info = messageReceived.split(" ");

                            if (info[0].toLowerCase().equals("get")) {
                                sendInfoBack(getSoldiersCount());
                            }
                            if (info[0].toLowerCase().equals("send")) {
                                if (info[2].toLowerCase().equals("bajas")) {
                                    long soldiersDown = Long.parseLong(info[3]);
                                    soldiersCount = soldiersCount - soldiersDown;
                                } else if (info[2].toLowerCase().equals("altas")) {
                                    long soldiersUp = Long.parseLong(info[3]);
                                    soldiersCount = soldiersCount + soldiersUp;
                                }
                            }
                        });
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private static void sendInfoBack(long soldiersCount2) {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'sendInfoBack'");
    }

    private static void sendBroadcast(String reporte) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress ipAddress = InetAddress.getByName("192.168.63.255");
            byte[] sendData = new byte[MAX_LENGTH];
            sendData = reporte.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, outPort);
            socket.send(sendPacket); // Envía el paquete al servidor
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getReporte(long soldiersCount) {
        String reporte = "Numero de soldados actuales: " + soldiersCount;
        return reporte;
    }

    public static long getSoldiersCount() {
        return soldiersCount;
    }
}
