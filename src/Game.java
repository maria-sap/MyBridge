package src;
import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private Player firstPlayer;
    private ArrayList<String> previousBids;

    public void biddingPhase(){
        for (Player player : players){
            if (player.getPlayerPosition() == 1) {
                firstPlayer = player;
            }
        }
    }
}