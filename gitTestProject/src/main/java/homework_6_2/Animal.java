package homework_6_2;

public class Animal {

    String colorA;
    String voiceA;
    String sizeA;
    String foodA;
    boolean meatOrPlants;

    public Animal() {
        System.out.println("Поздравляю, Вы создали новое животное! Оно обладает следующими свойствами.");
    }

    public Animal(String a, String b, String c, String d) {
        this.colorA = a;
        this.voiceA = b;
        this.sizeA = c;
        this.foodA = d;
    }

    public String getColorAnimal(String color) {
        return ("Цвет Вашего животного: " + color);
    }

    public void getVoiceAnimal(String voice) {
        System.out.println("Ваше животное может говорить " + voice);
    }

    public void checkSizeAnimal() {
        int sizeParse = Integer.parseInt(sizeA);
        if (sizeParse < 50) {
            System.out.println("Ваше животное маленькое");
        } else {
            System.out.println("Ваше животное большое");
        }
    }

    public boolean checkFoodAnimal(String food) {
        if (food.equalsIgnoreCase("y")) {
            System.out.println("Ваше животоное - плотоядное");
            return true;
        } else {
            System.out.println("Ваше животоное - травоядное");
            return false;
        }
    }

    public String checkIsAnimalPredator(String size, boolean foodMeat) {
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
