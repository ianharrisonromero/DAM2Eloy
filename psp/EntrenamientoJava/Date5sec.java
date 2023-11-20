package psp.EntrenamientoJava.Date;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.print.DocFlavor.INPUT_STREAM;

public class Date5sec {
  public static void main(String[] args) throws IOException, InterruptedException {
    while (true) {
      try {
        ProcessBuilder pb = new ProcessBuilder("date");
        Process p = pb.start();
        InputStream inputStream = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
          System.out.println(line);
        }
        Thread.sleep(5000);

      } catch (Exception e) {
        // TODO: handle exception
      }

    }
  }
}
