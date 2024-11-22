package src;
import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    private ArrayList<Card> handCards;

    public Hand(){
        handCards = new ArrayList<>();
    }

    public ArrayList<Card> getHandCards() {
        return handCards;
    }

    public void addCard(Card card) {
        handCards.add(card);
    }

    public void removeCard(int cardPosition) {
        handCards.remove(cardPosition);
    }

    public Hand orderHand() {
    Collections.sort(handCards, (Card c1, Card c2) -> {
        // First, compare suits (Clubs < Diamonds < Hearts < Spades)
        String[] suitOrder = {"C", "D", "H", "S"};
        int suitComparison = Integer.compare(
                java.util.Arrays.asList(suitOrder).indexOf(c1.getSuit()), 
                java.util.Arrays.asList(suitOrder).indexOf(c2.getSuit())
        );

        if (suitComparison != 0) {
            return suitComparison;
        }

        // If suits are the same, compare ranks
        return Integer.compare(c1.getRank(), c2.getRank());
    });

    return this; // Return the sorted hand
}

}
