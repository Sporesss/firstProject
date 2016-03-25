package homework_23_Threads;

import java.io.Serializable;

public class SerializableObject implements Serializable {
    private String name;
    private String surname;
    private int age;

    private static final long serialVersionUID = 8681480511904901439L;

    public SerializableObject() {
    }

    public SerializableObject(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "SerializableObject{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
