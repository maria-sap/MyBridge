package src;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cardsList = new ArrayList<>();
    private String[] suits = {"S", "H", "D", "C"};
    private int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; // 14 is Ace

    public Deck() {
        createCards();
        shuffleCards();
    }

    public void createCards() {
        for (String suit : suits) {
            for (int value : values) {
                cardsList.add(new Card(suit, value));
            }
        }
    }

    public void shuffleCards() {
        Collections.shuffle(cardsList);
    }

    public ArrayList<Card> getCards(){
        return cardsList;
    }

    /*
    public void dealCards(Player[] players) {
        for (int i = 0; i < cardsList.size(); i++) {
            players[i % 4].getHand().addCard(cardsList.get(i));
        }
    } */
}
