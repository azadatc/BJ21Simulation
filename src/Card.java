import java.util.HashMap;
import java.util.Map;

public class Card {

    public Suit suit;
    public Rank rank;
    public int cardValue;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.cardValue = rankValueMap.get(this.rank);
    }

    private Map<Rank, Integer> rankValueMap = new HashMap<Rank, Integer>()
    {
        {
            put(rank.ACE, 1);
            put(rank.TWO, 2);
            put(rank.THREE, 3);
            put(rank.FOUR, 4);
            put(rank.FIVE, 5);
            put(rank.SIX, 6);
            put(rank.SEVEN, 7);
            put(rank.EIGHT, 8);
            put(rank.NINE, 9);
            put(rank.TEN, 10);
            put(rank.JACK, 10);
            put(rank.QUEEN, 10);
            put(rank.KING, 10);
        }
    };
}
