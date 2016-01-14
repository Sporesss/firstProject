package homework_6;

import java.util.Scanner;

public class CreateAnimal {

    public static void main(String[] args) {

        String sizeAnimal = null;
        String foodAnimal = null;


        Scanner scanner = new Scanner(System.in);

        System.out.println("СОЗДАЙ СВОЁ ЖИВОТНОЕ!");

        System.out.println("Введите цвет животного: ");
        String colorAnimal = scanner.nextLine();
        System.out.println("Какие звуки издаёт животное?");
        String voiceAnimal = scanner.nextLine();
        System.out.println("Введите рост животного (см): ");
        sizeAnimal = scanner.next();

        while (!CheckSize(sizeAnimal)) {
            System.out.println("Введите рост в ЦИФРАХ!!!");
            sizeAnimal = scanner.next();
        }


        System.out.println("Животное питается мясом (нажите Y или N): ");
        foodAnimal = scanner.next();


        while (!foodAnimal.equalsIgnoreCase("Y") && !foodAnimal.equalsIgnoreCase("N"))  {
            System.out.println("Введите Y или N");
            foodAnimal = scanner.next();
        }

        Animal newAnimal = new Animal();
        System.out.println(newAnimal.ColorAnimal(colorAnimal));
        newAnimal.VoiceAnimal(voiceAnimal);
        newAnimal.SizeAnimal(sizeAnimal);
        boolean meat = newAnimal.FoodAnimal(foodAnimal);
        System.out.println(newAnimal.PredatorAnimal(sizeAnimal, meat));
    }

    public static boolean CheckSize(String checkSize) {
        try {
            Integer.parseInt(checkSize);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
