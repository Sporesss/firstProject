package homework_22_bugfixing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_2 {
    public static void main(String[] args) {
        Integer[] arr =new Integer[] {12,34,56,78,98,23};
        List<Integer> aList = Arrays.asList(arr);  //was fixed (I hope... or I had to use other way?)
        System.out.println(arr[2]);
        aList.set(2, 22);
        System.out.println(arr[2]);
    }
}
