package src;
import java.util.ArrayList;

public class Team {
    private boolean vulnerable;
    private int trickCount;
    private ArrayList<Player> teamPlayers;

    public Team(boolean vulnerable, int trickCount){
        this.vulnerable = vulnerable;
        this.trickCount = trickCount;
        teamPlayers = new ArrayList<>();
    }

    public void setTeam(Player player1, Player player2){
        teamPlayers.add(player1);
        teamPlayers.add(player2);
    }

    public boolean getVulnerabilityStatus(){
        return vulnerable;
    }

    public int getTrickCount(){
        return trickCount;
    }

    public ArrayList<Player> getTeamPlayers(){
        return teamPlayers;
    }
}
