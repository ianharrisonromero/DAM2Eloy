package bettinghouses_observer;

public class Bet365 implements BettingHouse {

    @Override
    public void update(String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
        System.out.printf("\nNEW GOAL (UPDATE RECEIVED) : %s %d - %s %d", homeTeam, homeGoals, awayTeam, awayGoals);
    }

}
