package homework_10.homework_10_3_boat;

public class Ship extends Boat {
    public Ship(String name, int speed, int weight) {
        super(name, speed, weight);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
