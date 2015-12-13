/**
 * Created by Pasha on 13.12.2015.
 */
public class Sum {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Run again and enter two digits ");
        }
        else {
            System.out.println("Sum = " + "[" + args[0] + "]" + " + " + "[" + args[1] + "]" + " = " + (Integer.parseInt(args[0]) + Integer.parseInt(args[1])));
        }

    }
}
