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
        System.out.print("Dealer: Drawing a new card ... " + newCard.rank + "\n");

        if(newCard.rank.equals(Rank.ACE)){
            // the logic with a soft hand goes here
        }

        handValue += newCard.cardValue;

        if(handValue > 21){
            System.out.print("Dealer: damn it ... busted at " + handValue + "\n");
            return false;
        }

        return true;
    }



    public boolean shouldDemandCard(Card dealerUpcard){
        if(handValue >= stayOn){
            System.out.print("Dealer: Staying on " + handValue + "\n" );
            return false;
        }

        return true;
    }
}
