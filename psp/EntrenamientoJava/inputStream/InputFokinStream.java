import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Process;
import java.lang.ProcessBuilder;

public class InputFokinStream {

    public static void main(String[] args) {

        int tiempoEspera;

        List<String> comandos = new ArrayList<>();
        comandos.add("date");
        // comandos.add("");

        if (args.length == 1) {

            try {
                tiempoEspera = Integer.parseInt(args[1]);

            } catch (Exception e) {
                System.err.println("Error convirtiendo a entero.");
                return;
            }

        } else if (args.length == 0) {

            System.out.println("Introduce los segundos que quieres de retraso: ");
            Scanner sc = new Scanner(System.in);
            tiempoEspera = sc.nextInt();
            sc.nextLine(); // LIMPIAR BUFFER limpiar Limpiar buffer Buffer

        } else {
            System.err.println("tas equivocao prim\n");
            return;
        }

        /// lo weno

        try {

            String linea;
            String resultado = "";

            while (true) {
                ProcessBuilder builder = new ProcessBuilder(comandos);
                Process proccess = builder.start();
                InputStream inStream = proccess.getInputStream();
                BufferedReader bReader = new BufferedReader(new InputStreamReader(inStream));

                while ((linea = bReader.readLine()) != null) {

                    System.out.println(linea);
                }
                Thread.sleep(tiempoEspera * 1000);
            }

        } catch (Exception e) {
            System.err.println("comeos una polla");
            e.printStackTrace();
        }
    }
}
