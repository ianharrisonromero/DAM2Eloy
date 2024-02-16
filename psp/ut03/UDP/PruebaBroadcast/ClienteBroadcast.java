import java.util.Scanner;

public class ClienteBroadcast {
    private static final int MAX_LENGTH = 65535;

    public static void main(String[] args) {

        Integer port = null;
        String msg;
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("Escribe un mensaje para mandar por broadcast:\n");
            msg = sc.nextLine();

            try(DatagramSocket socket = new DatagramSocket()) {
                InetAddress ipAddress = "172.20.0.3";
                byte[] sendData = new byte[MAX_LENGTH];
                sendData = msg.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
                socket.send(sendPacket); // Envía el paquete al servidor
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

    }

}
