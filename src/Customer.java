public class Customer extends Player{

    public int Cash;

    public Customer(int cash){
        stayOn = 17;
        Cash = cash;
        winCount = 0;
        lossCount = 0;
    }

    public boolean demandCard(Card dealerUpCard){
        // the logic to whether draw a card or not
        if(handValue >= stayOn){
            return false;
        }

        return true;
    }

    public boolean drawCard(Card newCard){

        if(newCard.rank.equals(Rank.ACE)){
            handValue += newCard.cardValue;
            isSoftHand = true;
        }

        if(handValue > 21){
            return false;
        }

        return true;
    }
}
