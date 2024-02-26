package ascensor_observer;

import java.util.List;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientAscensor implements Runnable {

    int id;
    int floor;
    int port;
    List<ServerSalaControl> observersList;
    Scanner sc = new Scanner(System.in);


    public ClientAscensor(int id, int port) {
        this.id = id;
        this.port = port;
    }

    @Override
    public void run() {
        while (true) {
            Socket socket;
            try {
                socket = new Socket("localhost", port);
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                System.out.println("->Ascensor " + id + "\n--->Introduce un número para moverte de planta:");
                int newFloor = sc.nextInt();
                changeFloor(newFloor);
                sc.nextInt(); // buffer
                out.writeUTF(id + ";" + newFloor);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void changeFloor(int newFloor) {
        floor = newFloor;
    }

}
