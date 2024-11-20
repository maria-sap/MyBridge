package src;

public class Contract {
    private int bidNumber;
    private String suit;
    private Player declarer;
    private int doubleMult;

    public Contract(int bidNumber, String suit, Player declarer) {
        this.bidNumber = bidNumber;
        this.suit = suit;
        this.declarer = declarer;
        this.doubleMult = 1;
    }

    // getters
    public int getBidNumber() {
        return bidNumber;
    }

    public String getSuit() {
        return suit;
    }

    public Player declarer() {
        return declarer;
    }

    public int getDoubleMult() {
        return doubleMult;
    }

    @Override
    public String toString() {
        return bidNumber + suit;
    }
}