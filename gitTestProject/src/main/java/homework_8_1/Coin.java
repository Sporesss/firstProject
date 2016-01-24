package homework_8_1;

public class Coin extends Money {

    Coin(float value) {
        super(value);
    }

    @Override
    void printKindOfMoney() {
        System.out.println("It's coins");
    }
}
