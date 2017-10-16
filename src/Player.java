import java.util.ArrayList;

public class Player {
    public int stayOn;
    public int handValue;
    public int winCount;
    public int lossCount;
    public boolean isSoftHand;
    public ArrayList<Card> handCards;

    public void ResetHand(){
        handValue = 0;
        handCards.clear();
    }

    public Card getTopCard(){
        if(!handCards.isEmpty()){
            return handCards.get(0);
        }

        return null;
    }

    public void winner(){
        winCount++;
    }

    public void loser(){
        lossCount++;
    }

    public boolean drawCard(Card newCard){
        throw new UnsupportedOperationException();
    }

    public boolean demandCard(Card dealerUpCard){
        throw new UnsupportedOperationException();
    }
}