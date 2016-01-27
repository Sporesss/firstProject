package homework_9;

import java.util.Random;

public class TestThings {
    public static void main(String[] args) {
        for (ThingsInMyTable things : ThingsInMyTable.values()) {
            System.out.println(things.toString());
        }

        ThingsInMyTable array[] = ThingsInMyTable.values();
        int i = 0;
        Random random = new Random();
        while (i < 3) {
            System.out.println(array[random.nextInt(array.length)].name());
            i++;
        }

        String description = "CAMERA_description";
        ThingsInMyTable thingsInMyTable = ThingsInMyTable.getThingByDescription(description);
        System.out.println("By description was found " + thingsInMyTable.name());
    }
}
