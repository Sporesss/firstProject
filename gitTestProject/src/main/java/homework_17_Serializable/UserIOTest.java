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

        User users[] = {
                new User("User #1", "Userov", 11),
                new User("User #2", "Adminov", 22),
                new User("User #3", "Loginov", 33)
        };

//        for (User user : users) {
//            writeObjectToFile(file, user);
//        }

        writeObjectToFile(file, users);

        readObjectFromFile(file);
    }

    private static void writeObjectToFile(File file, Object someObjects[]) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Object eachObject : someObjects) {
            objectOutputStream.writeObject(eachObject);
        }
//        objectOutputStream.writeObject(someObjects);
        objectOutputStream.close();
    }

    private static void readObjectFromFile(File file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object o;
        while ((o = objectInputStream.readObject()) != null) {
            System.out.println(o);
//            o = objectInputStream.readObject();
        }




//        List<Object> arrayList;
//        arrayList = Arrays.asList(objectInputStream.readObject());
//        for (Object object : arrayList) {
//            System.out.println(object);
//        }
//        Object objectFromFileArray[] = new Object[3];
//        for (int i = 0; i < objectFromFileArray.length; i++) {
//            objectFromFileArray[i] = objectInputStream.readObject();
//            System.out.println(objectFromFileArray[i]);
//        }
//        Object o = objectInputStream.readObject()
//        System.out.println(o);
    }
}
