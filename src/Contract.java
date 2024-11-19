package src;

public class Contract {
    private int bidNumber;
    private String suit;
    private Player declarer;
    private Team winningTeam; // Add this field to track the winning team

    // Constructor and other methods...

    // Get the winning team
    public Team getWinningTeam() {
        return winningTeam;
    }

    // Set the winning team (called after trick phase)
    public void setWinningTeam(Team winningTeam) {
        this.winningTeam = winningTeam;
    }

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