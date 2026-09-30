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
        private static int currentScore = 0;
        private static final int[] farkleArray = {0,0,0,0,0,0};

    public static int[] printMenu(int[] RollArray, String inputString) {
        /*
        contains all logic to print the menu based on the hand, meld, and score states
        updates frequently after the user makes any action
        */
        int [] occurrenceCount = Score.createOccurrenceList(RollArray);   
        currentScore = Score.scoreChart(occurrenceCount);
        if (currentScore == 0){
            System.out.println("\nFarkle! Score = 0");
            return farkleArray;
        }
        System.out.println("\nCurrent Hand:" + Arrays.toString(RollArray));  // looked this method up online
        System.out.println("Occurence of each die value (1 - 6) : " + Arrays.toString(occurrenceCount) + "\n");
        

        System.out.println("********** Current Hand and Meld **********");
        System.out.println("Die   Hand |   Meld");
        System.out.println("-----------+------------");

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            

            if (currentChar == 'A' && aBanked == true) {
                aBanked = false;
            }
            else if (currentChar == 'A' && aBanked == false){
                aBanked = true;
            }
            if (currentChar == 'B' && bBanked == true) {
                bBanked = false;
            }
            else if (currentChar == 'B' && bBanked == false){
                bBanked = true;
            }
            if (currentChar == 'C' && cBanked == true) {
                cBanked = false;
            }
            else if (currentChar == 'C' && cBanked == false){
                cBanked = true;
            }
            if (currentChar == 'D' && dBanked == true) {
                dBanked = false;
            }
            else if (currentChar == 'D' && dBanked == false){
                dBanked = true;
            }
            if (currentChar == 'E' && eBanked == true) {
                eBanked = false;
            }
            else if (currentChar == 'E' && eBanked == false){
                eBanked = true;
            }
            if (currentChar == 'F' && fBanked == true) {
                fBanked = false;
            }
            else if (currentChar == 'F' && fBanked == false){
                fBanked = true;
            }
        }

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

        System.out.println("\nCurrent Score: " + currentScore +"\n");


        return RollArray;

    }





    public static void turnProcess() {
        /*
        Allows the user to swap dice between hand and meld, as well as reroll selected dice
        Also allows user to end their turn of exit the game
        */


        int[] firstRollArray = Dice.firstRoll();   // used Claude to help me figure out how to import other classes and methods
        int[] newRollArray = printMenu(firstRollArray, "Z");
        Scanner scanner = new Scanner(System.in);  // found the scanner class for user input from google gen Ai
        System.out.print("Enter the Letter for your Choice: ");
        String userString = scanner.next().toUpperCase();
        Random random = new Random();
     
        

        while (!userString.equals("Q")) {
            if (Arrays.equals(newRollArray, farkleArray)) { // found this method for comparing list content from stack overflow notes
                return;
            }
            if (userString.equals("K")) {
                System.out.println("\nYour Final Score is: " + currentScore);
                return;
            }
            if (userString.equals("R")) {
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
            }
            if (Arrays.equals(newRollArray, farkleArray)) {
                return;
            }
            newRollArray = printMenu(newRollArray, userString);
            System.out.print("Enter the Letter for your Choice: ");
            userString = scanner.next().toUpperCase();
            
            
        }
        System.out.println("\nThank you for Playing!");
    }
}
