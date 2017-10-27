public class Main {

    public static void main(String[] args) {

        Game game = new Game(6);

        for (int i = 0 ; i< 20000; i++){
            game.dealTheShoe();
            game.dealTheShoe();
        }
    }
}

//    do not hit hard 12
//    Player ratio: %46.67
//    Player ratio: %53.33

//    hit hard 12
//    Player ratio: %46.67
//    Player ratio: %53.33

//    hit hard 13
//    Player ratio: %46.59
//    Player ratio: %53.41

//    hit hard 14
//    Player ratio: %46.45
//    Player ratio: %53.55