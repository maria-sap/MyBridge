package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create a new deck of cards
        Deck deck = new Deck();
        ArrayList<String> players = new ArrayList<>();
        ArrayList<Hand> hands = new ArrayList<>();

        players.add("1");
        players.add("2");
        players.add("3");
        players.add("4");
        

        
        for (Card card : deck.getCards()) {
            System.out.print(card );
        }
    }
}
