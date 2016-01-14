package homework_6_2;

import java.util.Scanner;

public class CreateAnimal {

    public static void main(String[] args) {

        String sizeAnimalVar = null;
        String foodAnimalVar = null;


        Scanner scanner = new Scanner(System.in);

        System.out.println("СОЗДАЙ СВОЁ ЖИВОТНОЕ!");

        System.out.println("Введите цвет животного: ");
        String colorAnimalVar = scanner.nextLine();
        System.out.println("Какие звуки издаёт животное?");
        String voiceAnimalVar = scanner.nextLine();
        System.out.println("Введите рост животного (см): ");
        sizeAnimalVar = scanner.next();

        while (!checkSize(sizeAnimalVar)) {
            System.out.println("Введите рост в ЦИФРАХ!!!");
            sizeAnimalVar = scanner.next();
        }


        System.out.println("Животное питается мясом (нажите Y или N): ");
        foodAnimalVar = scanner.next();


        while (!foodAnimalVar.equalsIgnoreCase("Y") && !foodAnimalVar.equalsIgnoreCase("N"))  {
            System.out.println("Введите Y или N");
            foodAnimalVar = scanner.next();
        }

        Animal newAnimalDefault = new Animal();
        Animal newAnimal = new Animal(colorAnimalVar, voiceAnimalVar, sizeAnimalVar, foodAnimalVar);

        System.out.println(newAnimalDefault.getColorAnimal(colorAnimalVar));
        newAnimalDefault.getVoiceAnimal(voiceAnimalVar);
        newAnimal.checkSizeAnimal();
        boolean meat = newAnimalDefault.checkFoodAnimal(foodAnimalVar);
        System.out.println(newAnimalDefault.checkIsAnimalPredator(sizeAnimalVar, meat));
    }

    public static boolean checkSize(String checkSize) {
        try {
            Integer.parseInt(checkSize);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
