import java.util.Scanner;

public class StartBanner {

    static public int numericPointGoal = 0;

    static void printBanner() {
        /*
        This simply prints the starting banner and allows the user to input a name for the player
        if no name is input, it defaults to "Unknown Player"
        */
        System.out.println("************************************************************************");
        System.out.println("*                      Zag Farkle by Jett Marleau                      *");
        System.out.println("*                             Copyright 2026                           *");
        System.out.println("************************************************************************\n");

        Scanner scanner = new Scanner(System.in);  // found the scanner class for user input from google gen Ai
        boolean accepted = false;
        String pointGoal = "";
        while (!accepted) {
            System.out.print("How many points would you like to play in this game? ");
            pointGoal = scanner.nextLine().trim(); // .trim() method needed to avoid whitespace errors

            if (pointGoal.equals("")) {
            pointGoal = "10000";
        } 
            accepted = true;

            for (char c : pointGoal.toCharArray()) { // approach cleaned by Claude
                if (c < '0' || c > '9') { 
                    accepted = false;
                    break;
                }
            }
        }
        numericPointGoal = Integer.parseInt(pointGoal);
        System.out.print("Enter a player name: ");
        String playerName = scanner.nextLine();
        if (playerName.equals("")) {
            playerName = "Unknown Player";
        }

        System.out.println(playerName + ", it's your turn! Rolling dice...");
    }
}