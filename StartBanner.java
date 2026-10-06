import java.util.Scanner;

public class StartBanner {

    static void printBanner() {
        System.out.println("************************************************************************");
        System.out.println("*                      Zag Farkle by Jett Marleau                      *");
        System.out.println("*                             Copyright 2026                           *");
        System.out.println("************************************************************************\n");

        Scanner scanner = new Scanner(System.in);  // found the scanner class for user input from google gen Ai
        System.out.print("Enter a player name: ");
        String playerName = scanner.nextLine();
        if (playerName.equals("")) {
            playerName = "Unknown Player";
        }

        System.out.println(playerName + ", it's your turn! Rolling dice...");
    }
}