

import java.lang.Math;

public class Matrix_1 {
    public static void main(String[] args) {

        int matrix[][] = new int[3][3];

        for (int i = 0; i<matrix.length; i++) {
            for (int j = 0; j<matrix.length; j++) {
                matrix[i][j] = ((j + 1) * ((int)Math.pow(2,((double)(i)))));
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
