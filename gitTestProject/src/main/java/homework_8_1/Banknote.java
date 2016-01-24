package homework_8_1;

public class Banknote extends Money {

    Banknote(int value) {
        super(value);
    }

    @Override
    void printKindOfMoney() {
        System.out.println("It's banknotes");
    }
}
