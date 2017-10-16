public class Dealer extends Player {

    public Card getTopCard(){
        if(!handCards.isEmpty()){
            return handCards.get(0);
        }

        return null;
    }

    public Dealer(){
        stayOn = 17;
    }

    public boolean drawCard(Card newCard){
        if(newCard.rank.equals(Rank.ACE)){
            // the logic with a soft hand goes here
        }

        handValue += newCard.cardValue;

        if(handValue > 21){
            return false;
        }

        return true;
    }

    public boolean demandCard(Card dealerUpcard){
        // the logic to whether draw a card or not
        // dealer's upcard is irrelevant
        if(handValue >= stayOn){
            return false;
        }

        return true;
    }
}
