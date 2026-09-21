public class Score {

    public static int countOccurrences(int[] array, int target) {  // used this approach from GeeksforGeeks occurence counting function
    int count = 0;
    for (int num : array) {
        if (num == target) {
            count++;
        }
    }
    return count;
}

    public static int[] createOccurrenceList(int[] array) {
    int onesCount = countOccurrences(array, 1);
    int twosCount = countOccurrences(array, 2);
    int threesCount = countOccurrences(array, 3);
    int foursCount = countOccurrences(array, 4);
    int fivesCount = countOccurrences(array, 5);
    int sixesCount = countOccurrences(array, 6);
    int[] occurrenceList = {onesCount, twosCount, threesCount, foursCount, fivesCount, sixesCount};
    return occurrenceList;
    }

    public static int scoreChart(int[] occurrenceList) {
    boolean straight = true;

    for (int num : occurrenceList) { // check for six of a kind
        if (num == 6) {
            return 3000; 
        }
    }
    for (int num : occurrenceList) { // check for a straight
        if (num != 1) {
            straight = false;
            break;
        }
    }
    if (straight == true) {
        return 1000;
    }
    int twosCount = 0;
    for (int num : occurrenceList) { // check for three pairs
        if (num == 2){
        twosCount ++;
        }
    }
    if (twosCount == 3){
        return 750;
    }
    if (occurrenceList[0] == 3){ // check for special triple
        return 1000;
    }

    int score = 0;
    for (int i = 0; i < occurrenceList.length; i++) { // check for a triple (could be two triples)
        if (occurrenceList[i] == 3) {
            score += 100 * (i + 1);
        }
    }
    for (int i = 0; i < occurrenceList.length; i++) { // check for four of a kind
        if (occurrenceList[i] == 4) {
            score +=  ( 100 * (i + 1)) * 2;
        }
    }
    for (int i = 0; i < occurrenceList.length; i++) { // check for five of a kind
        if (occurrenceList[i] == 5) { 
            score +=  ( 100 * (i + 1)) * 3;
        }
    }
    if (occurrenceList[0] <= 2) { // check for extra ones
        score += 100 * occurrenceList[0];
    }
    if (occurrenceList[4] <= 2) { // check for extra fives
        score += 50 * occurrenceList[4];
    }
    return score;
    }
}