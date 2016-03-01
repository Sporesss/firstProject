package homework_16_clone_JMX;


public class Sheep implements Cloneable, CLoneMXBean {
    private String name;
    private int age;
    private Sheep parent;
    public Sheep clone;

    public Sheep() {
    }

    public Sheep(String name, int age, Sheep parent) {
        this.name = name;
        this.age = age;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String methodForTest() {
        return "It's method for test!";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sheep getParent() {
        return parent;
    }

    public void setParent(Sheep parent) {
        this.parent = parent;
    }

    public Sheep getClone() {
        return clone;
    }

    public void setClone(Sheep clone) {
        this.clone = clone;
    }

    @Override
    protected Sheep clone() throws CloneNotSupportedException {
        Sheep cloneSheep = (Sheep) super.clone();
        Sheep parentSheep = cloneSheep.getParent() == null ? null : cloneSheep.getParent().clone();
        cloneSheep.setParent(parentSheep);
        return cloneSheep;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", parent=" + parent +
                '}';
    }

    public String createObjectFromBaseEntity() throws CloneNotSupportedException {
        Sheep parent = new Sheep("Dolly", 6, null);
        Sheep child = new Sheep(name , age, parent);
        clone = child.clone();
        return "The clone was created!";
    }

    public String getInformationAboutObject() {
        return clone == null ? "clone not found" : clone.toString();
    }
}
