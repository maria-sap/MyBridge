package src;
import java.util.ArrayList;


public class Team {
    public boolean vulnerable;
    public int trickCount;
    private ArrayList<Player> players;

    public Team() {
        players = new ArrayList<>();
    }

    public int getTrickCount(){
        return trickCount;
    }

    public boolean getVulnerablityStatus() {
        return vulnerable;
    }
    
    public ArrayList<Player> getTeamPlayers(){
        return players;
    }

    public void setTeam(Player x, Player y){
        players.add(x);
        players.add(y);
    }

    public void setVulnerable(boolean vulnerable) {
        this.vulnerable = vulnerable;
    }
}
