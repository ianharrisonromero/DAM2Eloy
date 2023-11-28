import java.io.IOException;
import java.util.Scanner;

public class ZipCompressor2ndVersion {
  public static void main(String[] args) throws IOException {

    ProcessBuilder pb;

    // if (args.length > 0) {
    // for (String path : args) {
    // pb = new ProcessBuilder();
    // pb.command("zip", "-r", path + ".zip", path);
    // pb.start();
    // }
    // } else {
    // System.out.println("NO ARGS");
    // }

    Scanner sc = new Scanner(System.in);
    System.out.print("Type a name for the .zip file : ");

    String fileName = sc.nextLine();

    for (int i = 0; i < args.length; i++) {
      pb = new ProcessBuilder();
      pb.command("zip", "-r", fileName + ".zip", args[i]);
      pb.start();

    }

  }
}