package src;

public class Player {
    private String playerName;
    private Hand playerHand;
    private int playerPosition;
    //private String playerRole;
    private int currentBidValue;
    private String currentBidSuit;

    // setter
    public Player(String playerName, Hand playerHand, int playerPosition, int currentBidValue, String currentBidSuit) {
        this.playerName = playerName;
        this.playerHand = playerHand;
        this.playerPosition = playerPosition;
        //this.playerRole = playerRole;
        this.currentBidValue = currentBidValue;
        this.currentBidSuit = currentBidSuit;
    }

    // getters
    // get player name
    public String playerName(){
        return playerName;
    }

    // get player hand
    public Hand getPlayerHand() {
        return playerHand;
    }

    // get player position
    public int getPlayerPosition() {
        return playerPosition;
    }

    // get player role 
    /* 
    public String getPlayerRole() {
        return playerRole;
    } */

    // get current bid value
    public int getCurrentBidValue() {
        return currentBidValue;
    }

    // get current bid suit
    public String getCurrentBidSuit() {
        return currentBidSuit;
    }

    public void playCard(int playingCardPosition){
        playerHand.removeCard(playingCardPosition);
    }
}
