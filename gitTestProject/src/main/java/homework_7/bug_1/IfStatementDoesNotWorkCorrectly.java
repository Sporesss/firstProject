package homework_7.bug_1;

import java.math.BigDecimal;

public class IfStatementDoesNotWorkCorrectly {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            double v1 = Math.random() * 5 + 1;
            String shirt = String.valueOf(BigDecimal.valueOf(v1).intValue());

            if (shirt.equals("1")) {  // We have to use 'equals' method for Strings
                System.out.println("It's 1!");//why this block does not work????))
            } else {
                System.out.println(shirt);
            }
        }
    }
}
