package homework_8;

public class FizzyWaterMachine {
    public static void main(String[] args) {
        Money money[] = {new Coin(),
                new Banknote()
        };

        for (Money someMoney:money) {
            someMoney.printKindOfMoney();
        }
    }
}
