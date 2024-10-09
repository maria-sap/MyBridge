package src;
public class Card {
    // initialise suit and rank parts of card
    public String suit;
    public int rank;

    // setter
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // getters
    // get suit
    public String getSuit() {
        return suit;
    }

    // get rank
    public int getRank() {
        return rank;
    }

    // make into single string - not sure if needed
    @Override
    public String toString() {
        return suit + rank;
    }
}