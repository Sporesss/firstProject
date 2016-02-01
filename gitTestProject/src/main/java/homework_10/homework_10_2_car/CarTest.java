package homework_10.homework_10_2_car;

public class CarTest {
    public static void main(String[] args) {
        CarObject carObject = new CarObject("Жигули", 100);
        carObject.printName();
        System.out.println("maxSpeed constant " + carObject.maxSpeed);
        System.out.println("minSpeed constant " + carObject.minSpeed);
        System.out.println("maxTheNumberOfPassengers constant " + carObject.maxTheNumberOfPassengers);
        System.out.println("minTheNumberOfPassengers constant " + carObject.minTheNumberOfPassengers);

    }
}
