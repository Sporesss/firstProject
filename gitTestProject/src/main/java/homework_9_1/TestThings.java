package homework_9_1;

import java.util.Random;

public class TestThings {
    public static void main(String[] args) {
        ThingsInMyTable array[] = ThingsInMyTable.values();

        for (ThingsInMyTable things : array) {
            System.out.println(things.toString());
        }

        int i = 0;
        int numberOfAttempts = 3;
        Random random = new Random();
        while (i < numberOfAttempts && i < array.length) {
            int randomThing = random.nextInt(array.length);
            System.out.println(array[randomThing].name());
            i++;
        }

        String description = "CAMERA_description";
        ThingsInMyTable thingsInMyTable = ThingsInMyTable.getThingByDescription(description);
        System.out.println("By description was found " + thingsInMyTable.name());
    }
}
