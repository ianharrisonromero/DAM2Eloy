import java.io.IOException;

public class ZipCompressor2ndVersion {
  public static void main(String[] args) throws IOException {

    ProcessBuilder pb;

    if (args.length > 0) {
      for (String path : args) {
        pb = new ProcessBuilder();
        pb.command("zip", "-r", path + ".zip", path);
        pb.start();
      }
    } else {
      System.out.println("NO ARGS");
    }

  }
}