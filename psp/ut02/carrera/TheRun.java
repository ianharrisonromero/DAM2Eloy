public class TheRun {
  public static final int TOTAL_KMS = 100;
  public static final int NUM_RUNNERS = 10;

  public static void main(String[] args) {

    Thread runnersArray[] = new Thread[NUM_RUNNERS];

    for (int i = 0; i < (NUM_RUNNERS); i++) {
      runnersArray[i] = new Thread(
          new Runner(TOTAL_KMS, i));
    }

    System.out.println("Ready... Step... GO!! ");

    for (int i = 0; i < runnersArray.length; i++) {
      runnersArray[i].start();
    }

    for (int i = 0; i < runnersArray.length; i++) {
      try {
        runnersArray[i].join();
      } catch (Exception e) {
        e.printStackTrace();
      }

    }

    System.out.println("The run is over.");

  }
}
