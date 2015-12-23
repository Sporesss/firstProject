package home;

import java.util.Random;
import java.util.Scanner;

public class ChangeMinMax {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество элементов в массиве: ");
        int number = in.nextInt();

        int []array = new int[number];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        int min = 0;
        int max = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[0]) {
                min = i;
            }
            else if (array[i] > array[array.length - 1]) {
                max = i;
            }
        }
        int x = array[min];
        array[min] = array[max];
        array[max]= x;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
