import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Date.DateLambda;
import Date.DateRunnable;
import Date.DateThread;

public class MainDate2 {

  public static void main(String[] args) {

    DateThread threadObject = new DateThread();
    threadObject.start();

    DateRunnable runnableObject = new DateRunnable();
    Thread threadRunnable = new Thread(runnableObject);
    threadRunnable.start();

    DateLambda lambdaObject = new DateLambda();
    Thread threadLambda = new Thread(lambdaObject);
    threadLambda.start();

  }

}

class DateLambda implements Runnable {

  public static final int MIN_ALEATORIO = 100;
  public static final int MAX_ALEATORIO = 999999999;

  @Override
  public void run() {
    while (true) {
      try {
        System.out.println("\n-> ");
        ProcessBuilder pb = new ProcessBuilder("date");
        Process p = pb.start();
        InputStream inputStream = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        System.out.println(esPrimo());

        while ((line = reader.readLine()) != null) {
          System.out.print(line);
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public String esPrimo() {
    int nPrimos = 0;
    int nNoPrimos = 0;
    boolean esPrimo;

    for (int j = 0; j < 100000000; j++) {
      int numAleatorio = (int) (MIN_ALEATORIO + Math.random() * (MAX_ALEATORIO - MIN_ALEATORIO));
      esPrimo = true;
      for (int i = 2; i <= Math.sqrt(numAleatorio); i++) {
        if (numAleatorio % i == 0) {
          esPrimo = false;
          break;
        }
      }
      if (esPrimo) {
        nPrimos += 1;
      } else {
        nNoPrimos += 1;
      }
    }
    try {
      Thread.sleep(11);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String msg = "\nSoy lambda y he encontrado " + nPrimos + " primos y " + nNoPrimos + " NO primos";
    return msg;

  }

}

class DateRunnable implements Runnable {

  public static final int MIN_ALEATORIO = 100000;
  public static final int MAX_ALEATORIO = 300001;

  @Override
  public void run() {
    while (true) {
      try {
        System.out.println("\n-> ");

        ProcessBuilder pb = new ProcessBuilder("date");
        Process p = pb.start();
        InputStream inputStream = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        System.out.println(esPrimo());

        while ((line = reader.readLine()) != null) {
          System.out.print(line);
        }

      } catch (Exception e) {
        e.printStackTrace();

      }

    }

  }

  public String esPrimo() {
    int nPrimos = 0;
    int nNoPrimos = 0;
    boolean esPrimo;

    for (int j = 0; j < 100000000; j++) {
      int numAleatorio = (int) (MIN_ALEATORIO + Math.random() * (MAX_ALEATORIO - MIN_ALEATORIO));
      esPrimo = true;
      for (int i = 2; i <= Math.sqrt(numAleatorio); i++) {
        if (numAleatorio % i == 0) {
          esPrimo = false;
          break;
        }
      }
      if (esPrimo) {
        nPrimos += 1;
      } else {
        nNoPrimos += 1;
      }
    }
    try {
      Thread.sleep(11);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String msg = "\nSoy DateRunnable y he encontrado " + nPrimos + " primos y " + nNoPrimos + " NO primos";
    return msg;

  }

}

class DateThread extends Thread {

  public static final int MIN_ALEATORIO = 100000;
  public static final int MAX_ALEATORIO = 300001;

  @Override
  public void run() {
    while (true) {
      try {
        System.out.println("\n-> ");

        ProcessBuilder pb = new ProcessBuilder("date");
        Process p = pb.start();
        InputStream inputStream = p.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        System.out.println(esPrimo());

        while ((line = reader.readLine()) != null) {
          System.out.print(line);
        }

      } catch (Exception e) {
        e.printStackTrace();

      }

    }

  }

  public String esPrimo() {
    int nPrimos = 0;
    int nNoPrimos = 0;
    boolean esPrimo;

    for (int j = 0; j < 100000000; j++) {
      int numAleatorio = (int) (MIN_ALEATORIO + Math.random() * (MAX_ALEATORIO - MIN_ALEATORIO));
      esPrimo = true;
      for (int i = 2; i <= Math.sqrt(numAleatorio); i++) {
        if (numAleatorio % i == 0) {
          esPrimo = false;
          break;
        }
      }
      if (esPrimo) {
        nPrimos += 1;
      } else {
        nNoPrimos += 1;
      }
    }
    try {
      Thread.sleep(11);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String msg = "\nSoy DateThread y he encontrado " + nPrimos + " primos y " + nNoPrimos + " NO primos";
    return msg;

  }
}
