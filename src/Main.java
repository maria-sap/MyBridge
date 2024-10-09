package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();

        // creating temporary players
        players.add(new Player(new Hand(), 1,  0, "None"));
        players.add(new Player(new Hand(), 2, 0, "None"));
        players.add(new Player(new Hand(), 3, 0, "None"));
        players.add(new Player(new Hand(), 4, 0, "None"));


        // Create a new deck of cards
        Deck deck = new Deck();
        
        /* printing the shuffled deck */
        /*
        int i = 1;
        for (Card card : deck.getCards()) {
            System.out.print(i);
            System.out.print(" - ");
            System.out.println(card);
            i++;
        } */

        deck.dealCards(players);

        for (Player player : players) {
            System.out.println("Player " + player.getPlayerPosition() + "'s hand:");
            for (Card card : player.getPlayerHand().getHandCards()) {
                System.out.println(card);  // Calls the toString method of Card class
            }
            System.out.println();
        }
    }
}
