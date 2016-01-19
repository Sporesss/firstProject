package homework_7_extra_2;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayInsideEnterLoop {

    String wordArray[] = {};
    boolean stopWasFound = true;

    public static void main(String[] args) {
        ArrayInsideEnterLoop arrayInsideEnterLoop = new ArrayInsideEnterLoop();
        arrayInsideEnterLoop.enterTheWord();
    }

    void enterTheWord() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the word ('stop' for exit): ");
            String word = scanner.nextLine();
            String checkWord = checkIfWordIsEmpty(word);

            updateWordArray(checkWord);
            checkIfStopInWordArray();

        } while (stopWasFound);
        arrayPrint(wordArray);
    }

    void checkIfStopInWordArray() {
        for (String words:wordArray) {
            if (words.equalsIgnoreCase("stop")) {stopWasFound = false; break;} else {stopWasFound = true;}
        }
    }

    void updateWordArray(String someWord) {
        String breakSentence[] = someWord.split(" ");
        String array[] = Arrays.copyOf(wordArray, wordArray.length + breakSentence.length);
        System.arraycopy(breakSentence, 0, array, wordArray.length, breakSentence.length);
        wordArray = Arrays.copyOf(array, array.length);
    }

    String checkIfWordIsEmpty(String string) {
        while (string.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter something");
            string = scanner.nextLine();
        }
        return string;
    }

    void arrayPrint(String someArray[]) {
        for (String words:someArray) {
            System.out.print(words + " ");
        }
    }
}
