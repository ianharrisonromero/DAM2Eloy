import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

class DateRunnable implements Runnable {
  @Override
  public void run() {
    while (true) {
      try {
        System.out.println("\n-> Runnable : ");

        ProcessBuilder pb = new ProcessBuilder("date");
        Process p = pb.start();
        InputStream inputStream = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
          System.out.print(line);
        }
        Thread.sleep(5000);

      } catch (Exception e) {
        e.printStackTrace();

      }

    }

  }

}
