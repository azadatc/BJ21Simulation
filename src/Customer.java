import java.util.ArrayList;

public class Customer extends Player{

    public int Cash;

    public Customer(int cash){
        stayOn = 17;
        Cash = cash;
        winCount = 0;
        lossCount = 0;
        handCards = new ArrayList<Card>();
    }

    public boolean drawCard(Card newCard){
        handCards.add(newCard);
        System.out.print("Player: Drawing a new card ... " + newCard.rank + "\n");
        if(newCard.rank.equals(Rank.ACE)){

        }

        handValue += newCard.cardValue;
        isSoftHand = true;

        if(handValue > 21){
            System.out.print("Player: damn it ... busted at " + handValue + "\n");
            return false;
        }

        return true;
    }

    public boolean shouldDemandCard(Card dealerUpCard){
        System.out.print("Player: dealer has a " + dealerUpCard.rank + " showing ... " + "\n");
        System.out.print("Player: I currently have ");

        for (Card card: handCards) {
            System.out.print(card.rank);
            System.out.print(" ");
        }

        System.out.print("\n");

        if(handValue >= stayOn){
            System.out.print("Player: Staying on " + handValue + "\n");
            return false;
        }

        return true;
    }
}
