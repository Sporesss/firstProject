package homework_22_bugfixing;

import java.util.Arrays;

public class Problem_5 {
    public static void main(String[] args) {
        Integer[] integers = {1, 6, 4, 3, 2, 21, 1};
        Arrays.sort(integers);                    //was fixed
        int i = binarySearchIterative(integers, 21);
        System.out.println(i);//---6?
        Arrays.sort(integers);
    }

    public static <T extends Number> int binarySearchIterative(T[] array, T keyElement) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int avg = low + (high - low) / 2;
            if (keyElement.equals(array[avg])) {
                return avg;
            } else if (keyElement.doubleValue() > array[avg].doubleValue()) {
                low = avg + 1;             //was fixed
            } else {
                high = avg - 1;            //was fixed
            }
        }
        return -1;
    }
}
