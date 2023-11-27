public class TheRealRun extends Thread {
    Object start;
    Object end;
    int number;
    int kmCovered;
    Long timeStart = 0L;
    Long timeEnd = 0L;
    Long runnerTime = 0L;

    public static final int TOTAL_KM = 100;
    public static final int KM_RANGE = 10;
    public static final long WAIT_TIME = 333;

    public TheRealRun(int number, Object start, Object end) {
        this.number = number;
        this.start = start;
        this.end = end;
        kmCovered = 0;
    }

    public int getNumber() {
        return number;
    }

    public int getKmCovered() {
        return kmCovered;
    }

    @Override
    public void run() {

        try {
            synchronized (start) {
                start.wait();
            }
            timeStart = System.currentTimeMillis();
            while (kmCovered < TOTAL_KM) {
                kmCovered += (int) (Math.random() * KM_RANGE);
                try {
                    Thread.sleep(WAIT_TIME);

                } catch (Exception e) {
                }
            }

            timeEnd = System.currentTimeMillis();

            synchronized (end) {
                end.notify();
            }
            

            runnerTime = timeEnd - timeStart;

            System.out.printf("Runner number %d has finished with time: %d mS\n", number, runnerTime);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "num: " + number + " / km : " + kmCovered;
    }

}
