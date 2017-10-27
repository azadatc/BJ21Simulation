public class Game {
    public Shoe shoe;
    public Player dealer;
    public Player customer;
    public int HandCount;

    public Game(int numberOfDecks){
        shoe = new Shoe(numberOfDecks);
        dealer = new Dealer();
        customer = new Customer(500);
        HandCount = 0;
    }

    public void dealHand(){
        System.out.println("Hand number: " + HandCount++);
        boolean customerBusted = false;

        customer.drawCard(shoe.draw());
        dealer.drawCard(shoe.draw());

        customer.drawCard(shoe.draw());
        dealer.drawCard(shoe.draw());

        // if either party has a 21, game is over
        if(dealer.hasBlackJack() || customer.hasBlackJack()){
            System.out.println("Blackjack !!");
            settleResults(dealer, customer);
            return;
        }

        // otherwise player starts playing
        while(customer.shouldTakeACard(dealer.getTopCard())){
            if(!customer.drawCard(shoe.draw())){
                customerBusted = true;
                break;
            };
        }

        // if customer hasn't busted yet, dealer start playing
        if(!customerBusted){
            while(dealer.shouldTakeACard(null)){
                if(!dealer.drawCard(shoe.draw())){
                    break;
                };
            }
        }

        // settle the results
        settleResults(dealer, customer);
    }

    private void settleResults(Player dealer, Player customer){
        // if the player has a black jack and the dealer does not
        if(customer.hasBlackJack() && !dealer.hasBlackJack())
        {
            dealer.loser();
            customer.blackJack();
        }

        // if player has busted the dealer wins
        else if(customer.handValue > 21){
            dealer.winner();
            customer.loser();
        }

        // if dealer has busted , means player hasn't
        else if(dealer.handValue > 21){
            dealer.loser();
            customer.winner();
        }

        else if(dealer.handValue > customer.handValue){
            dealer.winner();
            customer.loser();
        }

        else if(dealer.handValue < customer.handValue){
            dealer.loser();
            customer.winner();
        }

        dealer.resetHand();
        customer.resetHand();
    }

    public void dealTheShoe(){
        while(shoe.availableCards.size() > 50){
            dealHand();
        }
        printStats();
        shoe.shuffle();
    }

    public void printStats(){
        System.out.print("Player ratio: %" );
        System.out.printf("%.2f", 100 * (float)customer.winCount/(customer.winCount + dealer.winCount));
        System.out.println();
        System.out.print("Dealer ratio: %" );
        System.out.printf("%.2f", 100 * (float)dealer.winCount/(customer.winCount + dealer.winCount));
        System.out.println();
    }
}
