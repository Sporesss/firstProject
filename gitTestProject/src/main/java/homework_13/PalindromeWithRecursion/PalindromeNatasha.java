package homework_13.PalindromeWithRecursion;


import java.util.Scanner;

public class PalindromeNatasha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the word: ");
        String word = scanner.nextLine();
        System.out.println(palyndrom(word, 0, word.length() - 1));
    }

    private static boolean palyndrom(String str, int f, int l) {
        boolean b = str.charAt(f) == str.charAt(l);

        if (f < l && b) {
            b = palyndrom(str, ++f, --l);
        }
        return b;
    }
}
