package src;

public class Main {
    public static void main(String[] args) {
        // Create a match instance
        Match match = new Match();

        // Set up players and teams
        match.setupPlayers();

        // Start the match (running 3 games)
        match.start();
    }
}
