package homework_13.PalindromeWithRecursion;

import java.util.Scanner;

public class PalindromePasha {
    static char wordToArray[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word: ");
        String word = scanner.nextLine();
        wordToArray = word.toLowerCase().toCharArray();
        System.out.println(checkIfItPalindrome(0, wordToArray.length - 1));
    }

    static boolean checkIfItPalindrome(int firstIndex, int lastIndex) {
        if (firstIndex <= (wordToArray.length - 1)) {
            if (wordToArray[firstIndex] == wordToArray[lastIndex]) {
                checkIfItPalindrome ((firstIndex + 1), (lastIndex - 1));
            } else {
                return false;
            }
        }
        return true;
    }
}
