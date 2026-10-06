import java.util.Arrays;
import java.util.Random;
import java.util.Scanner; 

public class Turn {
    /*
    Contains all logic to create the user's turn
    holds several variables used to update the hand, meld, score, and check for farkles
    */

        private static boolean aBanked = true;  // used Claude to help format these variables and make their states persist outside of the printMenu function
        private static boolean bBanked = true;
        private static boolean cBanked = true;
        private static boolean dBanked = true;
        private static boolean eBanked = true;
        private static boolean fBanked = true;
        public static int meldScore = 0;
        public static int handScore = 0;
        public static int savedPoints = 0;
        private static final int[] farkleArray = {0,0,0,0,0,0};
        public static int [] meldOccurrenceArray = {0,0,0,0,0,0};
        public static int [] handOccurrenceArray = {0,0,0,0,0,0};
        public static boolean firstRoll = true;
        private static int[] rollOccurrenceCount = {0,0,0,0,0,0};


    
    private static int[] countHand(int[] dice) {
    boolean[] inHand = {aBanked, bBanked, cBanked, dBanked, eBanked, fBanked}; // claude recommended this improved array style of booleans over my original non-array style
    int[] counts = {0,0,0,0,0,0};
    for (int i = 0; i < 6; i++) {
        if (inHand[i] == true) {
            counts[dice[i] - 1] += 1;
        }
    }
    return counts;
    }
    
    
    
    public static int[] printMenu(int[] RollArray, String inputString) {
        /*
        contains all logic to print the menu based on the hand, meld, and score states
        updates frequently after the user makes any action
        */
        
        if (firstRoll == true) {
           rollOccurrenceCount = Score.createOccurrenceList(RollArray);  
           firstRoll = false;
           if (Score.scoreChart(rollOccurrenceCount) == 0) {
                System.out.println("\nFarkle! Score = 0");
                return farkleArray;
                }
        }

        System.out.println("\nCurrent Hand:" + Arrays.toString(RollArray));  // looked this method up online
        System.out.println("Occurence of each die value (1 - 6) : " + Arrays.toString(rollOccurrenceCount) + "\n");
        

        System.out.println("********** Current Hand and Meld **********");
        System.out.println("Die   Hand |   Meld");
        System.out.println("-----------+------------");

        

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            

            if (currentChar == 'A' && aBanked == true) {
                aBanked = false;
                rollOccurrenceCount[RollArray[0] - 1] -= 1;
                meldOccurrenceArray[RollArray[0] - 1] += 1;
            }
            else if (currentChar == 'A' && aBanked == false){
                aBanked = true;
                rollOccurrenceCount[RollArray[0] - 1] += 1;
                meldOccurrenceArray[RollArray[0] - 1] -= 1;
            }
            if (currentChar == 'B' && bBanked == true) {
                bBanked = false;
                rollOccurrenceCount[RollArray[1] - 1] -= 1;
                meldOccurrenceArray[RollArray[1] - 1] += 1;
            }
            else if (currentChar == 'B' && bBanked == false){
                bBanked = true;
                rollOccurrenceCount[RollArray[1] - 1] += 1;
                meldOccurrenceArray[RollArray[1] - 1] -= 1;
            }
            if (currentChar == 'C' && cBanked == true) {
                cBanked = false;
                rollOccurrenceCount[RollArray[2] - 1] -= 1;
                meldOccurrenceArray[RollArray[2] - 1] += 1;
            }
            else if (currentChar == 'C' && cBanked == false){
                cBanked = true;
                rollOccurrenceCount[RollArray[2] - 1] += 1;
                meldOccurrenceArray[RollArray[2] - 1] -= 1;
            }
            if (currentChar == 'D' && dBanked == true) {
                dBanked = false;
                rollOccurrenceCount[RollArray[3] - 1] -= 1;
                meldOccurrenceArray[RollArray[3] - 1] += 1;
            }
            else if (currentChar == 'D' && dBanked == false){
                dBanked = true;
                rollOccurrenceCount[RollArray[3] - 1] += 1;
                meldOccurrenceArray[RollArray[3] - 1] -= 1;
            }
            if (currentChar == 'E' && eBanked == true) {
                eBanked = false;
                rollOccurrenceCount[RollArray[4] - 1] -= 1;
                meldOccurrenceArray[RollArray[4] - 1] += 1;
            }
            else if (currentChar == 'E' && eBanked == false){
                eBanked = true;
                rollOccurrenceCount[RollArray[4] - 1] += 1;
                meldOccurrenceArray[RollArray[4] - 1] -= 1;
            }
            if (currentChar == 'F' && fBanked == true) {
                fBanked = false;
                rollOccurrenceCount[RollArray[5] - 1] -= 1;
                meldOccurrenceArray[RollArray[5] - 1] += 1;
            }
            else if (currentChar == 'F' && fBanked == false){
                fBanked = true;
                rollOccurrenceCount[RollArray[5] - 1] += 1;
                meldOccurrenceArray[RollArray[5] - 1] -= 1;
            }
        }
            meldScore = Score.scoreChart(meldOccurrenceArray);
            if (aBanked == true){
                System.out.println("(A)   " + RollArray[0] + "    |");
            } else{
                System.out.println("(A)   " + "     |    " + RollArray[0]);
            }
            if (bBanked == true){
                System.out.println("(B)   " + RollArray[1] + "    |");
            } else{
                System.out.println("(B)   " + "     |    " + RollArray[1]);
            }  
            if (cBanked == true){
                System.out.println("(C)   " + RollArray[2] + "    |");
            } else{
                System.out.println("(C)   " + "     |    " + RollArray[2]);
            }
            if (dBanked == true){
                System.out.println("(D)   " + RollArray[3] + "    |");
            } else{
                System.out.println("(D)   " + "     |    " + RollArray[3]);
            }
            if (eBanked == true){
                System.out.println("(E)   " + RollArray[4] + "    |");
            } else{
                System.out.println("(E)   " + "     |    " + RollArray[4]);
            }
            if (fBanked == true){
                System.out.println("(F)   " + RollArray[5] + "    |");
            } else{
                System.out.println("(F)   " + "     |    " + RollArray[5]);
            }

        System.out.println("\n(K) Keep meld score and end turn");
        System.out.println("(R) Reroll dice in hand");
        System.out.println("(Q) Quit Game");

        System.out.println("\nCurrent Score: " + meldScore +"\n");


        return RollArray;

    }



    private static boolean checkHotHands() {
    int meldCount = 0;
    for (int j = 0; j < 6; j++) {
        meldCount += meldOccurrenceArray[j];
    }
    if (meldCount != 6) {
        return false;
    }
    for (int k = 0; k < 6; k++) {
        if (meldOccurrenceArray[k] == 0) {
            continue;
        }
        meldOccurrenceArray[k] -= 1;
        int testScore = Score.scoreChart(meldOccurrenceArray);
        meldOccurrenceArray[k] += 1;
        if (testScore == meldScore) {
            return false; 
        }
    }
    return true;
    }

    public static void turnProcess(int[] testHand, boolean test) {
        /*
        Allows the user to swap dice between hand and meld, as well as reroll selected dice
        Also allows user to end their turn of exit the game
        */
       int[] firstRollArray;
        if (test == true) {
            firstRollArray = testHand;
        }
        else {
            firstRollArray = Dice.firstRoll();   // used Claude to help me figure out how to import other classes and methods
        }
        int[] newRollArray = printMenu(firstRollArray, "Z");
        if (Arrays.equals(newRollArray, farkleArray)) {
            return;
        }
        Scanner scanner = new Scanner(System.in);  // found the scanner class for user input from google gen Ai
        System.out.print("Enter the Letter for your Choice: ");
        String userString = scanner.next().toUpperCase();
        Random random = new Random();
     
        

        while (!userString.equals("Q")) {
            if (userString.equals("K")) {
                if (!Arrays.equals(meldOccurrenceArray, new int[]{0,0,0,0,0,0})) { // Geeks for Geeks helped show this approach fro comparing to an 0 only array
                   System.out.println("\nYour Final Score is: " + (meldScore + savedPoints));
                return; 
                }
                else {
                    System.out.println("\nError: must have dice melded to keep score and end turn");
                }
                
            }
            if (userString.equals("R")) {
                if (meldScore == 0) {
                    System.out.println("\nError: Must have a valid meld to reroll");
                    }
                else {
                    if (aBanked == true) {
                        newRollArray[0] = random.nextInt(6) + 1;
                    }
                    if (bBanked == true) {
                        newRollArray[1] = random.nextInt(6) + 1;
                    }
                    if (cBanked == true) {
                        newRollArray[2] = random.nextInt(6) + 1;
                    }
                    if (dBanked == true) {
                        newRollArray[3] = random.nextInt(6) + 1;
                    }
                    if (eBanked == true) {
                        newRollArray[4] = random.nextInt(6) + 1;
                    }
                    if (fBanked == true) {
                        newRollArray[5] = random.nextInt(6) + 1;
                    }
                    rollOccurrenceCount = countHand(newRollArray);
                    if (Score.scoreChart(rollOccurrenceCount) == 0) {
                        System.out.println("\nFarkle! Score = 0");
                        return;
                        }
                }
            }
            newRollArray = printMenu(newRollArray, userString);
            if (checkHotHands() == true) {

                System.out.println("***** HOT HAND! ***\nWould you like 6 new dice (y), or bank and end your turn? (n): ");
                savedPoints += meldScore;
                userString = scanner.next().toUpperCase();
                if ((!userString.equals("Y")) && (!userString.equals("N"))) {
                    System.out.println("Invalid Input: Would you like 6 new dice (y), or bank and end your turn? (n): ");
                    userString = scanner.next().toUpperCase();
                }
                if (userString.equals("Y")) {
                    newRollArray = Dice.firstRoll();
                    for (int i = 0; i < 5; i++) {
                        meldOccurrenceArray[i] = 0;
                    }
                    aBanked = true;
                    bBanked = true;
                    cBanked = true;
                    dBanked = true;
                    eBanked = true;
                    fBanked = true;
                }
                else {
                    userString = "K";
                    continue;
                }
            }
            System.out.print("Enter the Letter for your Choice: ");
            userString = scanner.next().toUpperCase();
            
            
            
        }
        System.out.println("\nThank you for Playing!");
    }
}