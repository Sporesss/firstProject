package homework_14;

import java.util.Scanner;

public class Palindrome {
    private static char wordToArray[];
    private String privateField = "Private field for test";

    public Palindrome() {
        System.out.println("It's Palindrome's constructor.");
    }

    private Palindrome(String privateField) {
        this.privateField = privateField;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word: ");
        String word = scanner.nextLine();
        wordToArray = word.toLowerCase().toCharArray();
        System.out.println(checkIfItPalindrome(0, wordToArray.length - 1));
    }

    private static boolean checkIfItPalindrome(int firstIndex, int lastIndex) {
        if (firstIndex <= (wordToArray.length - 1)) {
            if (wordToArray[firstIndex] == wordToArray[lastIndex]) {
                checkIfItPalindrome ((firstIndex + 1), (lastIndex - 1));
            } else {
                return false;
            }
        }
        return true;
    }

    private void privateMethodFromPalindrome() {
        System.out.println("Private Method From Palindrome was called.");
    }

    @Override
    public String toString() {
        return "Palindrome{" +
                "privateField='" + privateField + '\'' +
                '}';
    }
}
