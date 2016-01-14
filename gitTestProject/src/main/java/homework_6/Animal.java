package homework_6;

public class Animal {

    public Animal() {
        System.out.println("Поздравляю, Вы создали новое животное! Оно обладает следующими свойствами.");
    }

    public String ColorAnimal(String color) {
        return ("Цвет Вашего животного: " + color);
    }

    public void VoiceAnimal(String voice) {
        System.out.println("Ваше животное может говорить " + voice);
    }

    public void SizeAnimal(String size) {
        int sizeParse = Integer.parseInt(size);
        if (sizeParse < 50) {
            System.out.println("Ваше животное маленькое");
        } else {
            System.out.println("Ваше животное большое");
        }
    }

    public boolean FoodAnimal(String food) {
        if (food.equalsIgnoreCase("y")) {
            System.out.println("Ваше животоное - плотоядное");
            return true;
        } else {
            System.out.println("Ваше животоное - травоядное");
            return false;
        }
    }

    public String PredatorAnimal(String size, boolean foodMeat) {
        int sizeParse2 = Integer.parseInt(size);
        if (sizeParse2 < 50) {
            if (foodMeat) {
                return "Вы создали маленького, но жестокого хищника!";
            } else {
                return "Вы создали маленькое, милое животное.";
            }
        } else {
            if (foodMeat) {
                return "Вы создали огромного, ужасного хищника!";
            } else {
                return "Вы создали огромное, но безобидное животное!";
            }
        }
    }
}
