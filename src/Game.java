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
        customer.drawCard(shoe.draw());
        dealer.drawCard(shoe.draw());

        customer.drawCard(shoe.draw());
        dealer.drawCard(shoe.draw());

        while(customer.shouldDemandCard(dealer.getTopCard())){
            if(!customer.drawCard(shoe.draw())){
                break;
            };
        }

        while(dealer.shouldDemandCard(null)){
            if(!dealer.drawCard(shoe.draw())){
                break;
            };
        }

        settleResults(dealer, customer);
        dealer.ResetHand();
        customer.ResetHand();
    }

    private void settleResults(Player dealer, Player customer){
        if(dealer.handValue == customer.handValue){
            return;
        }

        if(dealer.handValue > customer.handValue){
            dealer.winner();
            customer.loser();
        }
        else{
            dealer.loser();
            customer.winner();
        }
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
