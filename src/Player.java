package src;

public class Player {
    private String playerName;
    private Hand playerHand;
    private int playerPosition;
    private int currentBidValue;
    private String currentBidSuit;
    private boolean hasPassed; // New field to track if the player has passed

    // Constructor
    public Player(String playerName, Hand playerHand, int playerPosition, int currentBidValue, String currentBidSuit) {
        this.playerName = playerName;
        this.playerHand = playerHand;
        this.playerPosition = playerPosition;
        this.currentBidValue = currentBidValue;
        this.currentBidSuit = currentBidSuit;
        this.hasPassed = false;
    }

    // Bid methods
    public void makeBid(int bidValue, String bidSuit) {
        this.currentBidValue = bidValue;
        this.currentBidSuit = bidSuit;
        this.hasPassed = false;
    }

    public void pass() {
        this.hasPassed = true;
    }

    public boolean hasPassed() {
        return hasPassed;
    }

    // Other existing getters
    public String getPlayerName() { return playerName; }
    public Hand getPlayerHand() { return playerHand; }
    public int getPlayerPosition() { return playerPosition; }
    public int getCurrentBidValue() { return currentBidValue; }
    public String getCurrentBidSuit() { return currentBidSuit; }
    
    public void playCard(int playingCardPosition){
        playerHand.removeCard(playingCardPosition);
    }
}
