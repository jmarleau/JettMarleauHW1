public class Farkle {
    public static void main(String[] args) {
        /*
        Main function that contains all running logic of the game
        Test invocations of turnProcess can be commented in or out to simplify output and make gameplay available
        */
        boolean notTest = false;
        boolean test = true;
        int[] defaultRandomArray = {};
        int[] testStraight = TestHands.testStraight();
        //Turn.turnProcess(testStraight, test);

        int[] testSixes = TestHands.testSixes();
        //Turn.turnProcess(testSixes, test);

        int[] triplePairs = TestHands.testTriplePairs();
        //Turn.turnProcess(triplePairs, test);

        int[] testFarkle = TestHands.testFarkle();
        // Turn.turnProcess(testFarkle, test);
        
        StartBanner.printBanner();
        Turn.turnProcess(defaultRandomArray, notTest);
    }
}