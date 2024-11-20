package src;

import java.util.ArrayList;

public class Team {
    private boolean vulnerable;
    private int trickCount;
    private ArrayList<Player> players;

    public Team() {
        players = new ArrayList<>();
        this.vulnerable = false;
    }

    public int getTrickCount() {
        return trickCount;
    }

    public boolean getVulnerablityStatus() {
        return vulnerable;
    }

    public ArrayList<Player> getTeamPlayers() {
        return players;
    }

    public void setTeam(Player x, Player y) {
        players.add(x);
        players.add(y);
    }

    public void setTrickCount(int trickCount) {
        this.trickCount = trickCount;
    }
}
