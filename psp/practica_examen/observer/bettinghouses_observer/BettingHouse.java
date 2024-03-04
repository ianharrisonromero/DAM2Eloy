package bettinghouses_observer;

// Observer
interface BettingHouse {
    void update(String homeTeam, String awayTeam, int homeGoals, int awayGoals);
}