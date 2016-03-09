package homework_19;

        import java.io.Serializable;

public class User implements Serializable {
    public String name;
    private String surname;
    private int age;

    private static final long serialVersionUID = 7620378417412886682L;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User: " +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age;
    }
}
