package homework_10.homework_10_2_car;

public abstract class Car implements Machine {
    String name;
    int speedNow;

    public Car(String name, int speedNow) {
        this.name = name;
        this.speedNow = speedNow;
    }

    void printName() {
        System.out.println("Name: " + name);
    }
}
