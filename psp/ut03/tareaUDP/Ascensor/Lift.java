import java.net.DatagramSocket;

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

    public String getSignal(){
        return code + ";" + getFloor() + ";" + getState();
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
        JLabel stateLabel = new JLabel("State : " + getState());
        JLabel currentFloorLabel = new JLabel("Floor : " + getFloor());

        panel.add(buttonDown);
        panel.add(buttonUp);
        panel.add(state);
        panel.add(currentFloor);

        buttonUp.addActionListener(li -> {
            floor++;
            stateLabel.setText(state.GOING_UP.toString());
            try {
                Thread.sleep(TRAVEL_TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
            currentFloorLabel.setText(getFloor());
            stateLabel.setText(state.STATIONARY.toString());
        });

        buttonDown.addActionListener(li -> {
            floor--;
            stateLabel.setText(state.GOING_DOWN.toString());
            try {
                Thread.sleep(TRAVEL_TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
            currentFloorLabel.setText(getFloor());
            stateLabel.setText(state.STATIONARY.toString());
        });

        while (true) {

            try {
                DatagramSocket socket = new DatagramSocket();
                InetAddress ipAddress = InetAddress.getByName(server);
                byte[] sendData = new byte[MAX_LENGTH];
                String sentence = getSignal(); // Mensaje a enviar
                sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, port);
                socket.send(sendPacket); // Envía el paquete al servidor
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Thread.sleep(LAPSE);
        }

    }

    public int getFloor() {
        return floor;
    }

    public String getState(){
        return state.toString();
    }

}
