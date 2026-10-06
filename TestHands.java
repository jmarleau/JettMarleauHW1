public class TestHands{

    static int[] testStraight() {
        // Should output 1000 points if all elements are melded immediately
        int[] straightTestArray = {1,2,3,4,5,6};
        return straightTestArray;
    }

    static int[] testSixes() {
        // Should output 1800 points if all elements are melded immediately
        int[] sixesTestArray = {6,6,6,6,6,2};
        return sixesTestArray;
    }

    static int[] testTriplePairs() {
        // Should output 750 points if all elements are melded immediately
        int[] triplePairsTestArray = {2,2,3,3,4,4};
        return triplePairsTestArray;
    }

    static int[] testFarkle() {
        // Should output a Farkle immediately
        int[] farkleTestArray = {2,3,4,6,2,3};
        return farkleTestArray;
    }
}