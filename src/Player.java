import java.util.ArrayList;

public class Player {
    public int stayOn;
    public int handValue;
    public float winCount;
    public float lossCount;
    public boolean isSoftHand;
    public ArrayList<Card> handCards;

    public void resetHand(){
        handValue = 0;
        isSoftHand = false;
        handCards.clear();
    }

    public Card getTopCard(){
        if(!handCards.isEmpty()){
            return handCards.get(0);
        }

        return null;
    }

    public boolean hasBlackJack(){
        if(handCards.get(0).rank.equals(Rank.ACE)){
            if(handCards.get(1).cardValue == 10){
                return true;
            }
        }

        if(handCards.get(0).cardValue == 10){
            if(handCards.get(1).rank.equals(Rank.ACE)){
                return true;
            }
        }

        return false;
    }

    public void winner(){
        winCount++;
    }

    public void blackJack() { throw new UnsupportedOperationException(); }

    public void loser(){
        lossCount++;
    }

    public boolean drawCard(Card newCard){
        throw new UnsupportedOperationException();
    }

    public boolean shouldTakeACard(Card dealerUpCard){
        throw new UnsupportedOperationException();
    }
}