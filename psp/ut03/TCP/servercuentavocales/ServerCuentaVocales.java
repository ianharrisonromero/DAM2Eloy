import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;


public class ServerCuentaVocales{

    public static void main(String[] args) {
        ServerSocket server;
        ArrayList<Character> letterList = new ArrayList<>();
        int vowelsCounter = 0;
        int consonantsCounter = 0;
            try {
            server = new ServerSocket(1234);
            while (true) {
                // Espera cliente
                Socket socket = server.accept();

                DataInputStream dataInputS = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputS = new DataOutputStream(socket.getOutputStream());
                String dataString = dataInputS.readLine().toString().trim();

                for (int i = 0; i < dataString.length(); i++) {
                    if (Character.isLetter(dataString.charAt(i))) {
                        letterList.add(dataString.charAt(i));
                    }
                }

                for (int j = 0; j < letterList.size(); j++) {
                    switch (letterList.get(j)) {
                        case 'a':
                            vowelsCounter++;
                            break;
                        case 'e':
                            vowelsCounter++;
                            break;
                        case 'i':
                            vowelsCounter++;
                            break;
                        case 'o':
                            vowelsCounter++;
                            break;
                        case 'u':
                            vowelsCounter++;
                            break;
                        default:
                            consonantsCounter++;
                            break;
                    }
                }

                System.out.println(
                        "Se han contado " + vowelsCounter + " vocales y " + consonantsCounter + " consonantes.");
                dataOutputS.writeUTF(
                        "Se han contado " + vowelsCounter + " vocales y " + consonantsCounter + " consonantes.");

                dataInputS.close();
                dataOutputS.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
