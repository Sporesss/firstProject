

/**
 * Created by Pasha on 13.12.2015.
 */

import java.util.Calendar;

public class MyCalendar {
    public static void main(String[] args) {
        Calendar calendarObject = Calendar.getInstance();

        int hour = calendarObject.getTime().getHours();
        System.out.println("Now is " + hour + " o'clock.");

        if ( 6 <= hour && hour <= 11 ) {
            System.out.println("Good morning!");
        }
        else if ( 12 <= hour && hour < 18) {
            System.out.println("Good day!");
        }
        else if ( 18 <= hour && hour < 24) {
            System.out.println("Good evening!");
        }
        else {
            System.out.println("Good night!");
        }
    }
}
