package homework_10.homework_10_3_boat;

public class ShipRaftTest {
    public static void main(String[] args) {
        Ship ship = new Ship("Queen Anna", 60, 7000);
        System.out.println("Ship name: " + ship.getName());
        System.out.println("Ship speed: " + ship.getSpeed());
        System.out.println("Ship weight: " + ship.getWeight());

        Raft raft = new Raft("Robinson Crusoe", 2, 200);
        System.out.println("Raft name: " + raft.getName());
        System.out.println("Raft speed: " + raft.getSpeed());
        System.out.println("Raft weight: " + raft.getWeight());
    }
}
