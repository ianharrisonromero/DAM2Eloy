import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 2_freeH
 */
public class FreeMemoria {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ls", "-a");

        while (true) {
            try {
                Process process = pb.start();
                InputStream stream = process.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("->\n->\n");
                
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}