import java.util.ArrayList;

public class Dealer extends Player {
    public Dealer()
    {
        stayOn = 17;
        winCount = 0;
        lossCount = 0;
        handCards = new ArrayList<Card>();
    }

    public boolean drawCard(Card newCard){
        handCards.add(newCard);
        System.out.println("Dealer: I Currently have: " + handValue);
        System.out.println("Dealer: Drawing a new card ... " + newCard.rank);

        if(newCard.rank.equals(Rank.ACE)){
            isSoftHand = true;
        }

        handValue += newCard.cardValue;

        if(handValue > 21){
            if(newCard.rank.equals(Rank.ACE)){
                // the logic with a soft hand goes here
                handValue -= 10;
                isSoftHand = false;
            }

            if(isSoftHand){
                handValue -= 10;
            }

            if(handValue > 21){
                System.out.println("Dealer: damn it ... busted at " + handValue);
                return false;
            }
        }

        return true;
    }

    public boolean shouldTakeACard(Card dealerUpcard){

        if(handValue == 17 && isSoftHand){
            System.out.println("Dealer: Dealer cannot stay on soft" + handValue);
            return true;
        }

        if(handValue >= stayOn){
            System.out.println("Dealer: Staying on " + handValue);
            return false;
        }

        return true;
    }
}
