import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Lift {
    int code;
    int floor = 0;
    Integer port = null;
    String server;
    LiftState state;
    JLabel stateLabel;
    JLabel currentFloorLabel;
    static final int TRAVEL_TIME = 1000;
    static final int LAPSE = 100;
    private static final int MAX_LENGTH = 65535;

    public Lift(int code, Integer port, String server) {
        this.code = code;
        this.port = port;
        this.server = server;
        state = LiftState.STATIONARY;
        start();
    }

    private void start() {
        JFrame frame = new JFrame("Lift number " + code);
        JPanel panel = new JPanel();
        frame.setResizable(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JButton buttonUp = new JButton("Up");
        JButton buttonDown = new JButton("Down");
        stateLabel = new JLabel("State : " + getState());
        currentFloorLabel = new JLabel("Floor : " + getFloor());

        panel.add(buttonDown);
        panel.add(buttonUp);
        panel.add(stateLabel);
        panel.add(currentFloorLabel);
        frame.add(panel);

        buttonUp.addActionListener(li -> {
            goUp();
        });

        buttonDown.addActionListener(li -> {
            goDown();
        });

        while (true) {

            try {
                DatagramSocket socket = new DatagramSocket();
                InetAddress ipAddress = InetAddress.getByName(server);
                byte[] sendData = new byte[MAX_LENGTH];
                String signal = getSignal(); // Mensaje a enviar
                sendData = signal.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
                socket.send(sendPacket); // Envía el paquete al servidor
                socket.close();
                Thread.sleep(LAPSE);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public String getFloor() {
        return String.valueOf(floor);
    }

    public String getState() {
        return state.toString();
    }

    public String getSignal() {
        return code + ";" + getFloor() + ";" + getState();
    }

    void goDown() {
        floor--;
        stateLabel.setText(state.GOING_DOWN.toString());
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(TRAVEL_TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
            state = LiftState.STATIONARY;
            currentFloorLabel.setText(getFloor());
            stateLabel.setText(getState());
        });
        t.start();
    }

    public void goUp() {
        floor++;
        stateLabel.setText(state.GOING_UP.toString());
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(TRAVEL_TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
            state = LiftState.STATIONARY;
            currentFloorLabel.setText(getFloor());
            stateLabel.setText(getState());
        });
        t.start();
    }

}
