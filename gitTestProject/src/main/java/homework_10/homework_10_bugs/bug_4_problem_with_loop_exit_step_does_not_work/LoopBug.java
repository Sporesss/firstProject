package homework_10.homework_10_bugs.bug_4_problem_with_loop_exit_step_does_not_work;

import java.util.Scanner;

public class LoopBug {
    public static void main(String[] args) {

        System.out.println("Enter an integer: ");

        Scanner entry = new Scanner(System.in);
        int input1 = entry.nextInt();

        System.out.println("Enter another integer: ");
        int input2 = entry.nextInt();

        int total = input1 + input2;

        while (input2 > 0) {
            System.out.println(total + "\nEnter another interger:  ");
            input2 = entry.nextInt();  // was fixed
            total += input2;           // was fixed
        }
    }
}
