import java.util.ArrayList;

public class Deck {
    public ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        for (Suit suit: Suit.values()){
            for(Rank rank : Rank.values()){
                cards.add(new Card(suit, rank));
            }
        }
    }
}