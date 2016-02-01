package homework_10.homework_10_1_fly;

public class FlyingObjectTest {
    public static void main(String[] args) {
        FlyingObject flyingObject = new FlyingObject("Plane", 1000, 10000, 33, "high");

        flyingObject.nameOut();
        System.out.println("speed: " + flyingObject.getSpeed());
        System.out.println("weight: " + flyingObject.getWeight());
        System.out.println("The Number Of Passengers: " + flyingObject.getTheNumberOfPassengers());
        System.out.println("Level Of Security: " + flyingObject.getLevelOfSecurity());
    }
}
