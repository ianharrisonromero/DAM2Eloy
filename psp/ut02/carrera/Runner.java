public class Runner implements Runnable{

  public Runner(int totalKms, int number) {
    this.totalKms = totalKms;
    this.number = number;
    coveredKms = 0;
  }

  int totalKms;
  int number;
  int coveredKms;
  static final long REST_TIME = 500;
  static final double MAX_KM_INTERVAL = 10;
  static final double STARTING_KMS = 0;
  static final String REST_MSG = "... Resting... ";

  @Override
  public void run() {
    System.out.printf("Im number %d, Im starting the race", number);
    while (coveredKms < totalKms) {
      try {
        Thread.sleep((long) (Math.random() * REST_TIME) + REST_TIME);
        System.out.println("# " + number + REST_MSG + " Ive done " + coveredKms + "/" + totalKms);
      } catch (Exception e) {
        e.printStackTrace();
      }

      coveredKms += Math.random() * MAX_KM_INTERVAL;

    }
    System.out.println("Ive finished, I am number " + number + " and I have done " + coveredKms + "kms.");
  }

}
