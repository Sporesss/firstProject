

/**
 * Created by Pasha on 13.12.2015.
 */
public class Calculator {
    public static void main(String[] anotherName) {

        if (anotherName.length != 2) {
            System.out.println("Run again and enter two digits ");
        }
        else {
            System.out.println("Sum = " + "[" + anotherName[0] + "]" +
                 " + " + "[" + anotherName[1] + "]" + " = " + 
                 (Integer.parseInt(anotherName[0]) + Integer.parseInt(anotherName[1])));
        }

    }
}
