package homework_10.homework_10_bugs.bug_1_array_index_out_of_bounds_exception;

import java.util.Scanner;

public class ArrayTest {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        int numberArray[] = new int[4];
        int findLowest;

        for (int i = 0; i < numberArray.length; i++) {       // was fixed
            System.out.println("Enter a value for slot " + (i + 1) + ":");
            numberArray[i] = input.nextInt();
        }
        findLowest = getMin(numberArray);
        displayOutput(findLowest);
    }

    public static int getMin(int num[]) {

        int lowestNum = num[0];        // was fixed
        for (int j = 0; j < num.length; j++) {        // was fixed
            if (num[j] < lowestNum) {      // was fixed
                lowestNum = num[j];      // was fixed
            }
        }
        return lowestNum;
    }

    public static void displayOutput(int lowest) {
        System.out.println("The lowest number is: " + lowest);
    }
}
