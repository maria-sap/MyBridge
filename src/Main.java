package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Deck deck = new Deck();
        Team team1 = new Team();
        Team team2 = new Team();

        // Creating temporary players
        players.add(new Player("Maria", new Hand(), 1, 0, "None"));
        players.add(new Player("Eryn", new Hand(), 2, 0, "None"));
        players.add(new Player("Magda", new Hand(), 3, 0, "None"));
        players.add(new Player("Enya", new Hand(), 4, 0, "None"));

        // Assigning players to teams
        team1.setTeam(players.get(0), players.get(2));
        team2.setTeam(players.get(1), players.get(3));

        // Dealing cards
        deck.dealCards(players);

        // Creating a game instance with players and deck
        Game game = new Game(players, deck);

        // Running the bidding phase
        System.out.println("Starting bidding phase...");
        game.biddingPhase();
    }
}
