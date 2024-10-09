package src;
import java.util.ArrayList;

public class Trick {
    private Card startCard;
    private String startSuit;
    private ArrayList<Card> trickCards;

    public Trick(Card startCard){
        this.startCard = startCard;
        trickCards = new ArrayList<>();
    }

    // setters
    // function to add card to array
    public void placeCard(Card card){
        trickCards.add(card);
    }

    // sets first card 
    public void retrieveLeadSuit(){
        startCard = trickCards.get(0);
        startSuit = startCard.getSuit();
    }

    // getters
    
    // get start suit
    public String getStartSuit(){
        return startSuit;
    }
}