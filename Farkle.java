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
        
        StartBanner.printBanner();
        while (true) {
            for (int i = 0; i < StartBanner.playerArray.length; i++) {
                Turn.turnProcess(defaultRandomArray, notTest, StartBanner.playerArray[i]);
                if (StartBanner.playerArray[i].score >= StartBanner.numericPointGoal) {
                    return;
                }
                if (Turn.userString.equals("Q")) {
                    return;
                }
            }
        }
        
    }
}