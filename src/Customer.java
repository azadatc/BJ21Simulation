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

        System.out.println("Player: Drawing a new card ... " + newCard.rank );

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
                System.out.println("Player: damn it ... busted at " + handValue);
                return false;
            }
        }

        return true;
    }

    public boolean shouldTakeACard(Card dealerUpCard){
        System.out.println("Player: dealer has a " + dealerUpCard.rank + " showing ... ");
        System.out.print("Player: I currently have ");

        for (Card card: handCards) {
            System.out.print(card.rank);
            System.out.print(" ");
        }

        System.out.print("\n");

        return PlayerStrategy.shouldIHit(handValue, dealerUpCard.cardValue, isSoftHand);
    }

    public void blackJack() { winCount += 1.5; }
}
