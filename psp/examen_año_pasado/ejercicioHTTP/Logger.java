package examen_año_pasado.ejercicioHTTP;

import java.io.*;

public class Logger implements PrimoObserver {

    @Override
    public void update(int primo) {
        String log = "\nPRIMO ENCONTRADO : " + primo + "\n";
        System.out.println(log);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true)); // true para hacer append
            writer.write(log);
            writer.write("\n-------------------------------\n");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
