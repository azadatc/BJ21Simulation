public class Main {

    public static void main(String[] args) {
	/// / write your code here
        Shoe shoe = new Shoe(1);
        shoe.shuffle();

        Card card = shoe.draw();
        System.out.print(card.rank);
        System.out.print(" ");
        System.out.print(card.suit);
        System.out.print(" ");
        System.out.print(card.cardValue);
        System.out.print("\n");

        Card card2 = shoe.draw();
        System.out.print(card2.rank);
        System.out.print(" ");
        System.out.print(card2.suit);
        System.out.print(" ");
        System.out.print(card2.cardValue);
        System.out.print("\n");

        for(Card card3: shoe.discarded){
                System.out.print(card3.rank);
                System.out.print(" ");
                System.out.print(card3.suit);
                System.out.print(" ");
                System.out.print(card3.cardValue);
                System.out.print("\n");
        }
    }
}
