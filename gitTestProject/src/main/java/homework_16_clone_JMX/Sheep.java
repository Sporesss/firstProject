package homework_16_clone_JMX;


public class Sheep implements Cloneable, CLoneMXBean {
    private String name;
    private int age;
    private Sheep parent;

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

    public Sheep createObjectFromBaseEntity() throws CloneNotSupportedException {
        Sheep parent = new Sheep("Dolly", 6, null);
        Sheep child = new Sheep("Molly" , 4, parent);
        Sheep cloneSheep = child.clone();
        return cloneSheep;
    }

    public String getInformationAboutObject(Sheep clone) {
        return clone.toString();
    }
}
