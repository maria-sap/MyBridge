package src;

import java.util.ArrayList;

public class Match {
    private ArrayList<Player> players;
    private Deck deck;
    private Team team1;
    private Team team2;
    private int numberOfGames = 3; // Total number of games in the match

    public Match() {
        players = new ArrayList<>();
        team1 = new Team();
        team2 = new Team();
    }

    public void setupPlayers() {
        // Creating temporary players
        players.add(new Player("Maria", new Hand(), 1, 0, "None"));
        players.add(new Player("Eryn", new Hand(), 2, 0, "None"));
        players.add(new Player("Magda", new Hand(), 3, 0, "None"));
        players.add(new Player("Enya", new Hand(), 4, 0, "None"));

        // Assigning players to teams
        team1.setTeam(players.get(0), players.get(2));
        team2.setTeam(players.get(1), players.get(3));
    }

    public void start() {
        for (int i = 0; i < numberOfGames; i++) {
            System.out.println("Starting Game " + (i + 1));

            // Create a new deck for each game
            deck = new Deck();

            // Deal cards to players before each game
            deck.dealCards(players);

            // Create a new game instance with the players and deck
            Game game = new Game(players, deck);

            // Running the bidding phase
            System.out.println("Starting bidding phase...");
            game.biddingPhase();

            // Check if a contract was made after bidding
            if (game.getContract() != null) {
                System.out.println("A contract has been made: " + game.getContract());
                System.out.println("Starting trick phase...");

                // Run the trick phase
                game.trickPhase();
            } else {
                System.out.println("No valid contract was made. Game over.");
            }

            // Determine game winner and update overall scores if needed
            determineGameWinner(game);
        }

        // Determine overall match winner
        determineMatchWinner();
    }

    private void determineGameWinner(Game game) {
        // Check if contract is not null
        Contract contract = game.getContract();
        if (contract != null) {
            Team winningTeam = contract.getWinningTeam();
            if (winningTeam != null) {
                if (winningTeam.equals(team1)) {
                    System.out.println("Team 1 wins Game");
                } else {
                    System.out.println("Team 2 wins Game");
                }
            } else {
                System.out.println("No winning team from the contract.");
            }
        } else {
            System.out.println("No contract was made for this game.");
        }
    }

    private void determineMatchWinner() {
        int team1Wins = getTeamWins(team1);
        int team2Wins = getTeamWins(team2);

        if (team1Wins > team2Wins) {
            System.out.println("Team 1 wins the match!");
        } else if (team2Wins > team1Wins) {
            System.out.println("Team 2 wins the match!");
        } else {
            System.out.println("The match is a draw!");
        }
    }

    private int getTeamWins(Team team) {
        int wins = 0;
        for (int i = 1; i <= numberOfGames; i++) {
            if (i % 2 == 0) { // For simplicity, every even game wins for Team 2
                if (team.equals(team2)) {
                    wins++;
                }
            } else { // Odd games wins for Team 1
                if (team.equals(team1)) {
                    wins++;
                }
            }
        }
        return wins;
    }
}
