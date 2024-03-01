// package bettinghouses;

public class ObserverPrimo implements PrimoInterface {

    @Override
    public void update(int number) {
        System.out.printf("\nEs primo : %d\n", number);
    }

}
