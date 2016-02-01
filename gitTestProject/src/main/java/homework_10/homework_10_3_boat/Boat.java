package homework_10.homework_10_3_boat;

public abstract class Boat {
    String name;
    int speed;
    int weight;

    public Boat(String name, int speed, int weight) {
        this.name = name;
        this.speed = speed;
        this.weight = weight;
    }

    public abstract String getName();

    public abstract int getSpeed();

    public abstract int getWeight();
}
