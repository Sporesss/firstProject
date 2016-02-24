package homework_16_clone_JMX;

public interface CLoneMXBean {

    Sheep createObjectFromBaseEntity() throws CloneNotSupportedException;

    String getInformationAboutObject(Sheep clone);
}
