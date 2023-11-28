import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTheRealRun {

    public static final int TOTAL_RUNNERS = 10;

    public static void main(String[] args) {

        List<TheRealRun> runnerList = new ArrayList<>();

        Object start = new Object();
        Object end = new Object();

        for (int runnerNumber = 1; runnerNumber < TOTAL_RUNNERS; runnerNumber++) {
            Thread runner = new Thread(new TheRealRun(runnerNumber, start, end));
            runnerList.add(runner);
            runner.start();
        }
        try {
            System.out.println("The Real Run is going to start in...");
            System.out.println("3");
            Thread.sleep(300);
            System.out.println("2");
            Thread.sleep(300);
            System.out.println("1");
            Thread.sleep(300);
            System.out.println("GO");

            synchronized (start) {
                start.notifyAll();

            }

        
            synchronized (end) {
                end.wait();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (TheRealRun r : runnerList) {
            if (r.isAlive()) {
                r.interrupt();
            }
        }

        runnerList.sort(Comparator.comparingInt(TheRealRun::getKmCovered).reversed());

        System.out.println(runnerList);

    }
}
