package home;

import java.util.Random;
import java.util.Arrays;

public class SumMultMatrixs {
    public static void main(String[] args) {
        int c[][] = new int[3][3];
        int d[][] = new int[3][3];
        int sumMatrix[][] = new int[c.length][c.length];
        int multMatrix[][] = new int[c.length][d.length];

        Random random = new Random();
//      Заполнение матриц случайными числами и сложение матриц
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                c[i][j] = random.nextInt(100);
                d[i][j] = random.nextInt(100);
                sumMatrix[i][j] = c[i][j] + d[i][j];
            }
        }
//      Умножение матриц
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                for (int k = 0; k < d.length; k++) {
                    multMatrix[i][j] += c[i][k] * d[k][j];
                }
            }
        }
//      Вывод массивов
        System.out.println("Matrix 'c'");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Matrix 'd'");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Sum: matrix 'c' + matrix 'd'");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Multiplication: matrix 'c' * matrix 'd'");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < d.length; j++) {
                System.out.print(multMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

//        Альтернативный вывод
//        System.out.println(Arrays.deepToString(c));
//        System.out.println(Arrays.deepToString(d));
//        System.out.println(Arrays.deepToString(sumMatrix));
//        System.out.println(Arrays.deepToString(multMatrix));
    }

}
