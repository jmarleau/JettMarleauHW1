public class Farkle {
    public static void main(String[] args) {
        /*
        Main function that contains all running logic of the game
        Test invocations of turnProcess can be commented in or out to simplify output and make gameplay available
        */
        boolean notTest = false;
        // boolean test = true;
        int[] defaultRandomArray = {};
        // int[] testStraight = TestHands.testStraight();
        // //Turn.turnProcess(testStraight, test);

        // int[] testSixes = TestHands.testSixes();
        // //Turn.turnProcess(testSixes, test);

        // int[] triplePairs = TestHands.testTriplePairs();
        // //Turn.turnProcess(triplePairs, test);

        // int[] testFarkle = TestHands.testFarkle();
        // // Turn.turnProcess(testFarkle, test);
        
        boolean gameplayLoopControl = true;

        StartBanner.printBanner();
        while (gameplayLoopControl == true) {
            for (int i = 0; i < StartBanner.playerArray.length; i++) {
                System.out.println("\n\n\n" + StartBanner.playerArray[i].name + " It's Your Turn!");
                Turn.turnProcess(defaultRandomArray, notTest, StartBanner.playerArray[i]);
                if (StartBanner.playerArray[i].score >= StartBanner.numericPointGoal) {
                    gameplayLoopControl = false;
                    break;
                }
                if (Turn.userString.equals("Q")) {
                    return;
                }
            }
        }
        System.out.println("Endgame Reached! Try to beat the highscore in one turn!");
        for (int i = 0; i < StartBanner.playerArray.length; i++) {
            if (StartBanner.playerArray[i].score >= StartBanner.numericPointGoal) {
                continue;
            }
            System.out.println("\n\n\n" + StartBanner.playerArray[i].name + " It's Your Turn!");
            Turn.turnProcess(defaultRandomArray, notTest, StartBanner.playerArray[i]);
            if (Turn.userString.equals("Q")) {
                break;
            }
        }
        Player highestScoringPlayer = StartBanner.playerArray[0];
        for (int i = 0; i < StartBanner.playerArray.length; i++) {
            if (StartBanner.playerArray[i].score > highestScoringPlayer.score) {
                highestScoringPlayer = StartBanner.playerArray[i];
            }
        }
        System.out.println("\n\n\n" + highestScoringPlayer.name + ": Congrats you win!");
        for (Player currentPlayer : StartBanner.playerArray) {
            System.out.println(currentPlayer.name + " Current Score: " + currentPlayer.score);
        }
        
    }
}