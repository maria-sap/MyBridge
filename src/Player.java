package src;

public class Player {
    private Hand playerHand;
    private int playerPosition;
    private String playerRole;
    private int currentBidValue;
    private String currentBidSuit;

    // setter
    public Player(Hand playerHand, int playerPosition, String playerRole, int currentBidValue, String currentBidSuit) {
        this.playerHand = playerHand;
        this.playerPosition = playerPosition;
        this.playerRole = playerRole;
        this.currentBidValue = currentBidValue;
        this.currentBidSuit = currentBidSuit;
    }

    // getters

    // get player hand
    public Hand getPlayerHand() {
        return playerHand;
    }

    // get player position
    public int getPlayerPosition() {
        return playerPosition;
    }

    // get player role
    public String getPlayerRole() {
        return playerRole;
    }

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
