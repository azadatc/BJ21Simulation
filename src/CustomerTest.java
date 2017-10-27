import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Player player;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        player = new Customer(400);
    }

    @org.junit.jupiter.api.Test
    void onInitalSoft19() {
        player.drawCard(new Card(Suit.CLUBS, Rank.ACE));
        player.drawCard(new Card(Suit.CLUBS, Rank.EIGHT));

        assertEquals(19, player.handValue);
        assertEquals(false, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.ACE)));
    }

    @org.junit.jupiter.api.Test
    void onInitalSoft17() {
        player.drawCard(new Card(Suit.CLUBS, Rank.ACE));
        player.drawCard(new Card(Suit.CLUBS, Rank.SIX));

        assertEquals(17, player.handValue);
        assertEquals(true, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.ACE)));

        player.drawCard(new Card(Suit.CLUBS, Rank.EIGHT));
        assertEquals(15, player.handValue);
        assertEquals(true, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.ACE)));
    }

    @org.junit.jupiter.api.Test
    void onInitalSoft18() {
        player.drawCard(new Card(Suit.CLUBS, Rank.ACE));
        player.drawCard(new Card(Suit.CLUBS, Rank.SEVEN));

        assertEquals(18, player.handValue);
        assertEquals(false, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.ACE)));
    }

    @org.junit.jupiter.api.Test
    void onInitalHard12AgainstBustCard() {
        player.drawCard(new Card(Suit.CLUBS, Rank.FIVE));
        player.drawCard(new Card(Suit.CLUBS, Rank.SEVEN));

        assertEquals(12, player.handValue);
        assertEquals(false, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.SIX)));
    }

    @org.junit.jupiter.api.Test
    void onInitalHard12AgainstAce() {
        player.drawCard(new Card(Suit.CLUBS, Rank.FIVE));
        player.drawCard(new Card(Suit.CLUBS, Rank.SEVEN));

        assertEquals(12, player.handValue);
        assertEquals(true, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.ACE)));

        player.drawCard(new Card(Suit.DIAMONDS, Rank.ACE));
        assertEquals(13, player.handValue);
        assertEquals(true, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.ACE)));
    }

    @org.junit.jupiter.api.Test
    void hitSoft17AgainstAnything() {
        player.drawCard(new Card(Suit.CLUBS, Rank.SIX));
        player.drawCard(new Card(Suit.CLUBS, Rank.ACE));

        assertEquals(17, player.handValue);
        assertEquals(true, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.ACE)));
        assertEquals(true, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.TWO)));
        assertEquals(true, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.KING)));
        assertEquals(true, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.NINE)));
        assertEquals(true, player.shouldTakeACard(new Card(Suit.CLUBS, Rank.SIX)));
    }
}