import java.util.Arrays;  
import java.util.Random;  // found this library online

public class Dice {
    public static int[] firstRoll() {
    int[] diceSet = {0, 0, 0, 0, 0, 0};
    Random random = new Random(); // saw this six side dice implementation from Bro Code's random numbers demo on Youtube
    for (int i = 0; i < 6; i++) {
        int roll = random.nextInt(6) + 1;
        diceSet[i] = roll;
    }
    System.out.println(Arrays.toString(diceSet)); // looked this up online
    return diceSet;
    }


    public static void main(String[] args)
    {
        int[] firstRollArray = firstRoll();   
        int [] occurrenceCount = Score.createOccurrenceList(firstRollArray);   // used Claude to help me figure out how to import other classes and methods
        int currentScore = Score.scoreChart(occurrenceCount);
        System.out.println(currentScore);
        }
    }

