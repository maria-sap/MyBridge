package src;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<>();
        Deck deck = new Deck();
        Team team1 = new Team();
        Team team2 = new Team();

        // creating temporary players
        players.add(new Player(new Hand(), 1,  0, "None"));
        players.add(new Player(new Hand(), 2, 0, "None"));
        players.add(new Player(new Hand(), 3, 0, "None"));
        players.add(new Player(new Hand(), 4, 0, "None"));
        
        team1.setTeam(players.get(0), players.get(2));
        team2.setTeam(players.get(1), players.get(3));

        System.out.println("team1");
        for (Player player : team1.getTeamPlayers()){
            System.out.println(player);
        }
        System.out.println("team2");
        for (Player player : team2.getTeamPlayers()){
            System.out.println(player);
        }

        /* printing the shuffled deck */
        /*
        int i = 1;
        for (Card card : deck.getCards()) {
            System.out.print(i);
            System.out.print(" - ");
            System.out.println(card);
            i++;
        } */

        deck.dealCards(players);

        /* printing player's hands */
        for (Player player : players) {
            System.out.println("Player " + player.getPlayerPosition() + "'s hand:");
            for (Card card : player.getPlayerHand().getHandCards()) {
                System.out.println(card);  // Calls the toString method of Card class
            }
            System.out.println();
        }


    }
}
