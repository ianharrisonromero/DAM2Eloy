import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

public class MainLifts {

    private static final int MAX_LENGTH = 65535;
    // public static Integer port = 8000;

    public static void main(String[] args) {
        int port = 8000;
        String server = "localhost";

        JFrame frame = new JFrame("Main Lifts");
        JPanel panel = new JPanel();

        frame.setResizable(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel label1 = new JLabel("Nothing yet");
        JLabel separator = new JLabel("\t|\t");
        JLabel label2 = new JLabel("Nothing yet");

        panel.add(label1);
        panel.add(separator);
        panel.add(label2);
        frame.add(panel);

        Lift lift1 = new Lift(01, port, server);
        Lift lift2 = new Lift(02, 8000, "localhost");

        try (DatagramSocket socket = new DatagramSocket(port)) {
            // Abre el socket en el puerto XXXX
            byte[] receivedData = new byte[MAX_LENGTH];

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
                socket.receive(receivedPacket); // Espera y recibe el paquete
                // ver la ip y el puerto ORIGEN del packet:
                // System.out.println(receivedPacket.getSocketAddress().toString());
                
                // Extrae la información del paquete
                String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                String[] splitMsg = message.split(";");
                switch (splitMsg[0]) {
                    case "1":
                        label1.setText(message);

                        break;
                    case "2":
                        label2.setText(message);

                        break;

                    default:
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
