package homework_15_bags.null_pointer_exceptions;

import java.util.Arrays;

public class ArrayTest2 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[i + 1];                         // the code was changed
            for (int j = 0; j < matrix[i].length; j++) {        // the code was changed
                matrix[i][j] = 1;
            }
        }

         //implements yours output according to the next style
        for(int[] matrix_ : matrix){
            System.out.println(Arrays.toString(matrix_));
        }

    }
}
/*
[1]
[1, 1]
[1, 1, 1]
[1, 1, 1, 1]
[1, 1, 1, 1, 1]
 */