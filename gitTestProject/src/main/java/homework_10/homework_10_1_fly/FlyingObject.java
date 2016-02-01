package homework_10.homework_10_1_fly;

public class FlyingObject implements Fly {
    String name;
    int speed;
    int weight;
    int numberOfPassenger;
    String levelOfSecurity;

    public FlyingObject(String name, int speed, int weight, int numberOfPassenger, String levelOfSecurity) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
        this.numberOfPassenger = numberOfPassenger;
        this.levelOfSecurity = levelOfSecurity;
    }

    public void nameOut() {
        System.out.println("The flying object has name: " + name);
    }

    public int getSpeed() {
        return speed;
    }

    public int getWeight() {
        return weight;
    }

    public int getTheNumberOfPassengers() {
        return numberOfPassenger;
    }

    public String getLevelOfSecurity() {
        return levelOfSecurity;
    }

}
