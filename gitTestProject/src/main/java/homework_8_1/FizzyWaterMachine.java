package homework_8_1;

public class FizzyWaterMachine {
    public static void main(String[] args) {
        Money money[] = {new Coin(0.5f),
                new Banknote(10)
        };

        for (Money someMoney:money) {
            someMoney.printKindOfMoney();
            System.out.println(someMoney.value);
        }
    }
}
