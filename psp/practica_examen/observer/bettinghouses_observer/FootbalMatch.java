package bettinghouses_observer;

import java.util.ArrayList;
import java.util.List;

// Subject
class FootballMatch {
    String homeTeam;
    String awayTeam;
    private int homeGoals;
    private int awayGoals;
    private List<BettingHouse> bettingHouses = new ArrayList<>();

    public void addObserver(BettingHouse bettingHouse) {
        bettingHouses.add(bettingHouse);
    }

    public void removeObserver(BettingHouse bettingHouse) {
        bettingHouses.remove(bettingHouse);
    }

    // Simulate a goal scored
    public void goalScored(String scoringTeam) {
        if (scoringTeam.equals(homeTeam)) {
            homeGoals++;
        } else if (scoringTeam.equals(awayTeam)) {
            awayGoals++;
        }
        notifyBettingHouses();
    }

    private void notifyBettingHouses() {
        for (BettingHouse bettingHouse : bettingHouses) {
            bettingHouse.update(homeTeam, awayTeam, homeGoals, awayGoals);
        }
    }
}

// Concrete Observers
// class Bet365 implements BettingHouse {
// @Override
// public void update(String homeTeam, String awayTeam, int homeGoals, int
// awayGoals) {
// System.out.println("Bet365: " + homeTeam + " " + homeGoals + " - " + awayTeam
// + " " + awayGoals);
// }
// }

// class WilliamHill implements BettingHouse {
// @Override
// public void update(String homeTeam, String awayTeam, int homeGoals, int
// awayGoals) {
// System.out.println("William Hill: " + homeTeam + " " + homeGoals + " - " +
// awayTeam + " " + awayGoals);
// }
// }
