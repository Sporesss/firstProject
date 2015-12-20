

import java.util.Scanner;

public class Pascal {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int rows = input.nextInt();

        int triangle[][] = new int[rows + 1][rows*2 + 1];
        triangle[0][rows] = 1;
        String centre = "%" + rows*2 + "d";
        System.out.printf(centre, 1);
        System.out.println();

        for (int i = 1; i < (triangle.length - 1); i++) {
            for (int j = 1; j < (rows*2); j++) {
                if ((triangle[i - 1][j - 1] != 0) || (triangle[i - 1][j + 1] != 0)) {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j + 1];
                    System.out.printf("%2d", triangle[i][j]);
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}