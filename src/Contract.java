package src;

public class Contract {
    private int bidNumber;
    private String suit;
    private Player declarer;

    public Contract(int bidNumber, String suit, Player declarer) {
        this.bidNumber = bidNumber;
        this.suit = suit;
        this.declarer = declarer;
    }

    // getters
    public int getBidNumber(){
        return bidNumber;
    }

    public String getSuit(){
        return suit;
    }

    public Player declarer(){
        return declarer;
    }

    @Override
    public String toString(){
        return bidNumber + suit;
    }
}