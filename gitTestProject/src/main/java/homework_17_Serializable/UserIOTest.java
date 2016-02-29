package homework_17_Serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UserIOTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path = Paths.get("C://JavaCourse");
        File file = new File(path.toAbsolutePath() + "/SerializableFile.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        User user1 = new User("User #1", "Userov", 11);
        User user2 = new User("User #2", "Adminov", 22);
        User user3 = new User("User #3", "Loginov", 33);

        writeObjectToFile(file, user3);

        readObjectFromFile(file);

    }

    private static void writeObjectToFile(File file, Object o) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
    }

    private static void readObjectFromFile(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o = objectInputStream.readObject();
        System.out.println(o);
    }


}
