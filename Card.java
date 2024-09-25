public class Card {
    // initialise suit and rank parts of card
    private String suit;
    private int rank;


    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    // make into single string - not sure if required
    @Override
    public String toString() {
        return suit + rank;
    }
}