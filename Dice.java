import java.util.Random;  

public class Dice {
    /*
    The class models the simple behavior of rolling a dice
    The dice integer generation is random and saves 6 different 1 - 6 values to an Array
    That array is then passed to the Score class to be processed
    */
    public static int[] firstRoll() {
    int[] diceSet = {0, 0, 0, 0, 0, 0};
    Random random = new Random(); // saw this six side dice implementation from Bro Code's random numbers demo on Youtube
    for (int i = 0; i < 6; i++) {
        int roll = random.nextInt(6) + 1;
        diceSet[i] = roll;
    }
    return diceSet;
    }
    }

