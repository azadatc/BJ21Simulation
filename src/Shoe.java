import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Shoe {
    public ArrayList<Deck> decks;
    public ArrayList<Card> discarded;
    public ArrayList<Card> allCards;

    private Random _rand = new Random();

    public Shoe(int numberOfDecks){
        decks = new ArrayList<Deck>();
        discarded = new ArrayList<Card>();
        allCards = new ArrayList<Card>();

        for(int i = 0 ; i < numberOfDecks ; i++){
            decks.add(new Deck());
        }

        for (Deck deck: decks){
            for (Card card : deck.cards){
                allCards.add(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(allCards);
    }

    public Card draw(){
        if(allCards.isEmpty()){
            return null;
        }

        Card retCard = allCards.remove(getRandomInt(allCards.size()));
        this.discarded.add(retCard);
        return retCard;
    }

    private int getRandomInt(int max){
        return _rand.nextInt(max-1)+1;
    }
}
