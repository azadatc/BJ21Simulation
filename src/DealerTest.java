import static org.junit.jupiter.api.Assertions.*;

class DealerTest {
    Player player;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        player = new Dealer();
    }

    @org.junit.jupiter.api.Test
    void onInitialSoft19() {
        player.drawCard(new Card(Suit.CLUBS, Rank.ACE));
        player.drawCard(new Card(Suit.CLUBS, Rank.EIGHT));

        assertEquals(19, player.handValue);
        assertEquals(false, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.ACE)));
    }

    @org.junit.jupiter.api.Test
    void onInitialSoft17() {
        player.drawCard(new Card(Suit.CLUBS, Rank.ACE));
        player.drawCard(new Card(Suit.CLUBS, Rank.SIX));

        assertEquals(17, player.handValue);
        assertEquals(true, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.ACE)));

        player.drawCard(new Card(Suit.CLUBS, Rank.EIGHT));
        assertEquals(15, player.handValue);
        assertEquals(true, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.ACE)));
    }

    @org.junit.jupiter.api.Test
    void onInitialSoft18() {
        player.drawCard(new Card(Suit.CLUBS, Rank.ACE));
        player.drawCard(new Card(Suit.CLUBS, Rank.SEVEN));

        assertEquals(18, player.handValue);
        assertEquals(false, player.shouldTakeACard(null));
    }

    @org.junit.jupiter.api.Test
    void onInitial16() {
        player.drawCard(new Card(Suit.CLUBS, Rank.NINE));
        player.drawCard(new Card(Suit.CLUBS, Rank.SEVEN));

        assertEquals(16, player.handValue);
        assertEquals(true, player.shouldTakeACard(null));

        assertEquals(false, player.drawCard(new Card(Suit.DIAMONDS, Rank.NINE)));
    }

    @org.junit.jupiter.api.Test
    void onInitialHard12AgainstAce() {
        player.drawCard(new Card(Suit.CLUBS, Rank.FIVE));
        player.drawCard(new Card(Suit.CLUBS, Rank.SEVEN));

        assertEquals(12, player.handValue);
        assertEquals(true, player.shouldTakeACard(null));

        player.drawCard(new Card(Suit.DIAMONDS, Rank.ACE));
        assertEquals(13, player.handValue);
        assertEquals(true, player.shouldTakeACard(null));
    }
}