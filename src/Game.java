package src;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Player> players;
    private Deck deck;
    private Player firstPlayer;
    private Contract contract;
    private ArrayList<String> previousBids;

    // Valid suits
    private final String[] validSuits = {"C", "D", "H", "S"};

    public Game(ArrayList<Player> players, Deck deck) {
        this.players = players;
        this.deck = deck;
        this.previousBids = new ArrayList<>();
    }

    public void biddingPhase() {
        while (true) {  // Loop for reshuffling if all players pass
            findFirstPlayer();
            int startingIndex = players.indexOf(firstPlayer);
            int highestBidValue = 0;
            String highestBidSuit = "";
            Player highestBidder = null;
            int passCount = 0; // Track passes
            boolean firstRound = true; // Track if this is the first round of bidding
            Scanner scanner = new Scanner(System.in);

            // Start the bidding loop
            int currentIndex = startingIndex;

            while (true) { // This will continue until we break out due to a condition met
                Player currentPlayer = players.get(currentIndex);

                // Display current player's name and last bid
                System.out.println(currentPlayer.getPlayerName() + "'s turn to bid.");
                System.out.println("Last highest bid: " + highestBidValue + highestBidSuit);

                // Variable to track if a valid bid has been made
                boolean validBid = false;

                while (!validBid) {
                    // Ask for bid or pass
                    System.out.print("Enter your bid (e.g., '2H' for 2 Hearts) or 'pass' to pass: ");
                    String input = scanner.nextLine().trim();

                    if (input.equalsIgnoreCase("pass")) {
                        passCount++;
                        currentPlayer.pass(); // Mark the player as having passed
                        validBid = true; // Move on to the next player
                    } else {
                        // Extract bid value and suit from input
                        int bidValue;
                        String bidSuit;

                        try {
                            bidValue = Integer.parseInt(input.substring(0, input.length() - 1));
                            bidSuit = input.substring(input.length() - 1).toUpperCase(); // Assuming suit is the last character

                            // Validate the suit
                            if (!isValidSuit(bidSuit)) {
                                System.out.println("Invalid suit. Please use one of the following suits: C, D, H, S.");
                                continue; // Prompt the player again
                            }

                            // Check for the first round bid
                            if (firstRound) {
                                if (bidValue > highestBidValue || (bidValue == highestBidValue && isHigherSuit(bidSuit, highestBidSuit))) {
                                    // New highest bid
                                    highestBidValue = bidValue;
                                    highestBidSuit = bidSuit;
                                    highestBidder = currentPlayer;
                                    previousBids.add(bidValue + bidSuit);
                                    System.out.println(currentPlayer.getPlayerName() + " bids " + bidValue + bidSuit);
                                    passCount = 0; // Reset pass count if there’s a new bid
                                    validBid = true; // Valid bid was made
                                    firstRound = false; // After a valid bid, it's no longer the first round
                                } else {
                                    System.out.println("Bid not high enough. Please bid higher.");
                                }
                            } else {
                                // After the first round, we can accept bids
                                if (bidValue > highestBidValue || (bidValue == highestBidValue && isHigherSuit(bidSuit, highestBidSuit))) {
                                    // New highest bid
                                    highestBidValue = bidValue;
                                    highestBidSuit = bidSuit;
                                    highestBidder = currentPlayer;
                                    previousBids.add(bidValue + bidSuit);
                                    System.out.println(currentPlayer.getPlayerName() + " bids " + bidValue + bidSuit);
                                    passCount = 0; // Reset pass count if there’s a new bid
                                    validBid = true; // Valid bid was made
                                } else {
                                    System.out.println("Bid not high enough. Please bid higher.");
                                }
                            }
                        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                            System.out.println("Invalid input. Please enter a valid bid or 'pass'.");
                        }
                    }
                }

                // Move to the next player in a circular fashion
                currentIndex = (currentIndex + 1) % players.size();

                // Check if we need to reshuffle or end the bidding phase
                if (firstRound && passCount >= 4) {
                    // All players passed without making any bids
                    System.out.println("All players passed without making any bids. Reshuffling the deck and re-bidding...");
                    deck.shuffleCards(); // Assuming your Deck class has a shuffle method
                    // Reset necessary variables for the new bidding phase
                    highestBidValue = 0;
                    highestBidSuit = "";
                    highestBidder = null;
                    passCount = 0; // Reset pass count for the new bidding round
                    firstRound = true; // Reset to first round
                    currentIndex = startingIndex; // Reset to the first player
                    continue; // Restart the bidding loop
                } else if (!firstRound && passCount >= 3) {
                    // Three passes after a valid bid
                    System.out.println("Three consecutive passes. Bidding phase ends.");
                    break; // End the bidding phase
                }
            }

            // If we reached here and we had valid bids, we can finalize the contract
            if (highestBidder != null) {
                contract = new Contract(highestBidValue, highestBidSuit, highestBidder);
                System.out.println("Winning contract: " + contract);
            } else {
                System.out.println("All players passed, no contract was made.");
            }

            // Exit bidding phase if we have a valid contract
            break; // Break from the while(true) that allows for reshuffling
        }
    }

    private void findFirstPlayer() {
        // Find the starting player (dealer)
        for (Player player : players) {
            if (player.getPlayerPosition() == 1) {
                firstPlayer = player;
                break;
            }
        }
    }

    // Helper function to compare suits
    private boolean isHigherSuit(String suit1, String suit2) {
        String[] suitOrder = {"C", "D", "H", "S"}; // Club, Diamond, Heart, Spade
        int index1 = java.util.Arrays.asList(suitOrder).indexOf(suit1);
        int index2 = java.util.Arrays.asList(suitOrder).indexOf(suit2);
        return index1 > index2;
    }

    // Validate if the suit is one of the allowed suits
    private boolean isValidSuit(String suit) {
        for (String validSuit : validSuits) {
            if (validSuit.equals(suit)) {
                return true; // Valid suit found
            }
        }
        return false; // No valid suit found
    }
    public Contract getContract() {
        return contract;
    }

    public void trickPhase() {
        int numberOfTricks = 13; // Total tricks in a bridge game
        Player trickLeader = firstPlayer; // The player who leads the first trick
        Team team1 = new Team();
        Team team2 = new Team();

        // Assign players to teams (assuming alternating positions belong to the same team)
        team1.setTeam(players.get(0), players.get(2));
        team2.setTeam(players.get(1), players.get(3));

        Scanner scanner = new Scanner(System.in);

        // Loop through each trick
        for (int trick = 1; trick <= numberOfTricks; trick++) {
            System.out.println("\nTrick " + trick + " begins.");

            ArrayList<Card> cardsPlayed = new ArrayList<>();
            String leadSuit = null; // Suit of the first card played
            Player trickWinner = null;
            Card highestCard = null;

            // Each player plays a card in turn
            for (int i = 0; i < players.size(); i++) {
                Player currentPlayer = players.get((players.indexOf(trickLeader) + i) % players.size());

                System.out.println(currentPlayer.getPlayerName() + ", it's your turn.");
                System.out.println("Your hand: " + currentPlayer.getPlayerHand().getHandCards());
                System.out.print("Select a card to play (index 0-" + (currentPlayer.getPlayerHand().getHandCards().size() - 1) + "): ");

                Card playedCard = null;
                while (true) {
                    try {
                        int cardPosition = Integer.parseInt(scanner.nextLine());
                        playedCard = currentPlayer.getPlayerHand().getHandCards().get(cardPosition);

                        // Validate the card (follow lead suit if possible)
                        if (leadSuit == null || playedCard.getSuit().equals(leadSuit) || !currentPlayerHasSuit(currentPlayer, leadSuit)) {
                            currentPlayer.playCard(cardPosition);
                            cardsPlayed.add(playedCard);

                            if (leadSuit == null) {
                                leadSuit = playedCard.getSuit(); // Set the lead suit
                            }

                            System.out.println(currentPlayer.getPlayerName() + " played: " + playedCard);
                            break;
                        } else {
                            System.out.println("You must follow the lead suit (" + leadSuit + ") if possible.");
                        }
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("Invalid input. Please select a valid card index.");
                    }
                }

                // Determine the current highest card of the lead suit
                if (playedCard.getSuit().equals(leadSuit)) {
                    if (highestCard == null || playedCard.getRank() > highestCard.getRank()) {
                        highestCard = playedCard;
                        trickWinner = currentPlayer;
                    }
                }
            }

            // Announce the winner of the trick
            System.out.println("Trick winner: " + trickWinner.getPlayerName());
            trickLeader = trickWinner; // Winner of the trick leads the next trick

            // Assign the trick to the winning team
            if (team1.getTeamPlayers().contains(trickWinner)) {
                team1.trickCount++;
            } else {
                team2.trickCount++;
            }
        }

        // Display results
        System.out.println("\nTrick phase complete!");
        System.out.println("Team 1 (Players: " + team1.getTeamPlayers().get(0).getPlayerName() + ", " + team1.getTeamPlayers().get(1).getPlayerName() + ") won " + team1.getTrickCount() + " tricks.");
        System.out.println("Team 2 (Players: " + team2.getTeamPlayers().get(0).getPlayerName() + ", " + team2.getTeamPlayers().get(1).getPlayerName() + ") won " + team2.getTrickCount() + " tricks.");
    }

    private boolean currentPlayerHasSuit(Player player, String suit) {
        for (Card card : player.getPlayerHand().getHandCards()) {
            if (card.getSuit().equals(suit)) {
                return true;
            }
        }
        return false;
    }
}
