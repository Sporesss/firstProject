package homework_22_bugfixing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Problem_1 {

    public static void main(String[] args) {
        String[] membersArray = new String[]{"1", "2", "3", "4", "5"};
        List<String> membersList = new ArrayList(Arrays.asList(membersArray)); // was fixed (I hope... or I had to use other way?); говорили на паре - вспомните за remove и add --- есть некоторые траблы) обойти можно
        System.out.println("membersList before remove: " + membersList);

        Iterator<String> iterator = membersList.iterator();

        for (String member : membersList) {
            List<String> seeAlso = new ArrayList<String>();   //was fixed
            if (!seeAlso.contains(member)) {
                seeAlso.add(member);
            }
        }

        while (iterator.hasNext()) {          //was fixed
            iterator.next();
            iterator.remove();
        }
        System.out.println("membersList after remove: " + membersList);
    }
}

