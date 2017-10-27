public class PlayerStrategy {
    public static boolean shouldIHit(int currentValue, int dealerUpCardValue, boolean isSoft){
        if(currentValue <= 11) {
            return true;
        }

        if(currentValue == 17 && isSoft){
            return true;
        }

        if(dealerUpCardValue >= 7){
            if(currentValue < 17){
                return true;
            }
        }

        if(currentValue == 12) {
            if(dealerUpCardValue == 2){
                return PlayerSettings.Hit12Against2;
            }
            if(dealerUpCardValue == 3){
                return PlayerSettings.Hit12Against3;
            }
            if(dealerUpCardValue == 4){
                return PlayerSettings.Hit12Against4;
            }
            if(dealerUpCardValue == 5){
                return PlayerSettings.Hit12Against5;
            }
            if(dealerUpCardValue == 6){
                return PlayerSettings.Hit12Against6;
            }

            return false;
        }

        if(currentValue == 13) {
            if(dealerUpCardValue == 2){
                return PlayerSettings.Hit13Against2;
            }
            if(dealerUpCardValue == 3){
                return PlayerSettings.Hit13Against3;
            }
            if(dealerUpCardValue == 4){
                return PlayerSettings.Hit13Against4;
            }
            if(dealerUpCardValue == 5){
                return PlayerSettings.Hit13Against5;
            }
            if(dealerUpCardValue == 6){
                return PlayerSettings.Hit13Against6;
            }

            return false;
        }

        if(currentValue == 14) {
            if(dealerUpCardValue == 2){
                return PlayerSettings.Hit14Against2;
            }
            if(dealerUpCardValue == 3){
                return PlayerSettings.Hit14Against3;
            }
            if(dealerUpCardValue == 4){
                return PlayerSettings.Hit14Against4;
            }
            if(dealerUpCardValue == 5){
                return PlayerSettings.Hit14Against5;
            }
            if(dealerUpCardValue == 6){
                return PlayerSettings.Hit14Against6;
            }

            return false;
        }

        if(currentValue == 15) {
            if(dealerUpCardValue == 2){
                return PlayerSettings.Hit15Against2;
            }
            if(dealerUpCardValue == 3){
                return PlayerSettings.Hit15Against3;
            }
            if(dealerUpCardValue == 4){
                return PlayerSettings.Hit15Against4;
            }
            if(dealerUpCardValue == 5){
                return PlayerSettings.Hit15Against5;
            }
            if(dealerUpCardValue == 6){
                return PlayerSettings.Hit15Against6;
            }

            return false;
        }

        if(currentValue == 16) {
            if(dealerUpCardValue == 2){
                return PlayerSettings.Hit16Against2;
            }
            if(dealerUpCardValue == 3){
                return PlayerSettings.Hit16Against3;
            }
            if(dealerUpCardValue == 4){
                return PlayerSettings.Hit16Against4;
            }
            if(dealerUpCardValue == 5){
                return PlayerSettings.Hit16Against5;
            }
            if(dealerUpCardValue == 6){
                return PlayerSettings.Hit16Against6;
            }

            return false;
        }

        return false;

    }

}
