package src;
import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private ArrayList<Card> handCards;

    public Hand() {
        handCards = new ArrayList<>();
    }

    public void addCard(Card card) {
        handCards.add(card);
    }

    public void removeCard(Card card) {
        handCards.remove(card);
    }

    public void orderHand() {
        Collections.sort(handCards, (Card c1, Card c2) -> {
            if (c1.getSuit().equals(c2.getSuit())) {
                return Integer.compare(c1.getRank(), c2.getRank());
            }
            return c1.getSuit().compareTo(c2.getSuit());
        });
    }

    public ArrayList<Card> getHandCards() {
        return handCards;
    }
}
