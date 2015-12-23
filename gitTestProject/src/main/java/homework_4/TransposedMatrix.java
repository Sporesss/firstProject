package home;

import java.util.Random;
import java.util.Scanner;

public class TransposedMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите число строк матрицы: ");
        int n = in.nextInt();
        System.out.println("Введите число столбцов матрицы: ");
        int m = in.nextInt();

        int array[][] = new int[n][m];
        int transArray[][] = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i][j] = transArray[j][i] = random.nextInt(100);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(transArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}
