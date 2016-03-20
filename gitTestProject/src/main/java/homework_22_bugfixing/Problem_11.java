package homework_22_bugfixing;

import java.util.ArrayList;

public class Problem_11 {
    private ArrayList<String> storedStrings = new ArrayList<String>();    //was fixed
    int index = 0;    //was fixed

    public Problem_11() {
        if (index < storedStrings.size()) {     //was fixed
            this.breakString(storedStrings.get(index));     //was fixed
        }
    }

    private void breakString(String s) {
        if (s.length() > 9) {
            storedStrings.add(0, s.substring(s.length() - 9, s.length()));
            this.breakString(s.substring(0, s.length() - 9));
        } else {
            this.storedStrings.add(0, s);
        }
    }


    public static void main(String[] args) {
        new Problem_11();
    }
}
