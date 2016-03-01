package homework_16_clone_JMX;

public interface CLoneMXBean {

    String createObjectFromBaseEntity() throws CloneNotSupportedException;

    String getInformationAboutObject();

    String getName();

    void setName(String name);

    String methodForTest();

    int getAge();

    void setAge(int age);
}
