package homework_22_bugfixing;

import java.util.Arrays;

public class Problem_4 {
    public static void main(String[] args) {
        int[] masForCopy = new int[]{1, 3, 4, 5, 6, 7, 8};
        System.out.println("before changes " + masForCopy);
        masForCopy = Arrays.copyOf(masForCopy, 3);   //was fixed
        System.out.println("after changes " + masForCopy);//is it the same?)))))
    }
}
