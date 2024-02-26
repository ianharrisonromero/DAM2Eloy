package bettinghouses;

public class Main {

  public static void main(String[] args) {
    // Setting up the football match
    FootballMatch match = new FootballMatch();
    match.homeTeam = "Manchester United";
    match.awayTeam = "Liverpool";

    // Registering betting houses as observers
    Bet365 bet365 = new Bet365();
    // BettingHouse williamHill = new WilliamHill();
    match.addObserver(bet365);
    // match.addObserver(williamHill);

    // Simulating match events
    match.goalScored("Manchester United");
    match.goalScored("Liverpool");
    match.goalScored("Manchester United");
    match.goalScored("Manchester United");
  }
}
