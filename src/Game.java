public class Game {
    public Shoe shoe;
    public Player dealer;
    public Player customer;

    public Game(int numberOfDecks){
        shoe = new Shoe(numberOfDecks);
        dealer = new Dealer();
        customer = new Customer(200);
    }

    public void dealHand(){
        boolean customerBusted = false;

        customer.drawCard(shoe.draw());
        dealer.drawCard(shoe.draw());

        customer.drawCard(shoe.draw());
        dealer.drawCard(shoe.draw());

        // if either party has a 21, game is over
        if(dealer.hasTwentyOne() || customer.hasTwentyOne()){
            settleResults(dealer, customer);
            customer.resetHand();
            dealer.resetHand();
            return;
        }

        // otherwise player starts playing
        while(customer.shouldDemandCard(dealer.getTopCard())){
            if(!customer.drawCard(shoe.draw())){
                customerBusted = true;
                break;
            };
        }

        // if customer hasn't busted yet, dealer start playing
        if(customerBusted){
            while(dealer.shouldDemandCard(null)){
                if(!dealer.drawCard(shoe.draw())){
                    break;
                };
            }
        }

        // settle the results
        settleResults(dealer, customer);

    }

    private void settleResults(Player dealer, Player customer){
        if(dealer.handValue > customer.handValue){
            dealer.winner();
            customer.loser();
        }

        if(dealer.handValue < customer.handValue){
            dealer.loser();
            customer.winner();
        }

        dealer.resetHand();
        customer.resetHand();
    }

    public void dealTheShoe(){
        while(shoe.availableCards.size() > 20){
            dealHand();
        }

        printStats();
    }

    public void printStats(){
        System.out.print("Player: Win: " + customer.winCount + " and loss: " + customer.lossCount + "\n");
        System.out.print("Dealer: Win: " + dealer.winCount + " and loss: " + dealer.lossCount + "\n");
    }
}
