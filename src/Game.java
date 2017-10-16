public class Game {
    public Shoe shoe;
    public Player dealer;
    public Player customer;

    public Game(){
        shoe = new Shoe(4);
        dealer = new Dealer();
        customer = new Customer(200);
    }

    public void dealHand(){
        customer.handCards.add(shoe.draw());
        dealer.handCards.add(shoe.draw());
        customer.handCards.add(shoe.draw());
        dealer.handCards.add(shoe.draw());

        while(customer.demandCard(dealer.getTopCard())){
            customer.drawCard(shoe.draw());
        }

        while(dealer.demandCard(null)){
            dealer.drawCard(shoe.draw());
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
}
