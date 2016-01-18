package homework_7_extra;

import java.util.Scanner;

public class ArrayInsideEnterLoop {

    String wordArray[] = new String[1];
    boolean stopWasFound = true;
    int i;

    public static void main(String[] args) {
        ArrayInsideEnterLoop arrayInsideEnterLoop = new ArrayInsideEnterLoop();
        arrayInsideEnterLoop.enterTheWord();
    }

    void enterTheWord() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the word ('stop' for exit): ");
            String word = scanner.nextLine();

            updateWordArray(checkIfWordIsEmpty(word));
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
        i++;
        String array[] = new String[i];
        System.arraycopy(wordArray, 0, array, 0, wordArray.length);
        array[i - 1] = someWord;
        wordArray = new String[i];
        System.arraycopy(array, 0, wordArray, 0, array.length);
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
