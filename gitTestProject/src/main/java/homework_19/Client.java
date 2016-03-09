package homework_19;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Logger;

public class Client {
    static Logger logger = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User users[] = {
                new User("User #1", "Userov", 11),
                new User("User #2", "Adminov", 22),
                new User("User #3", "Loginov", 33),
                null
        };

        int port = 7777;
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket clientSocket = new Socket(inetAddress, port);
        logger.info(clientSocket.toString());

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

        sendObjectsToServer(users, objectOutputStream);
        getChangedUsersFromServer(objectInputStream);

        objectOutputStream.close();
        objectInputStream.close();
    }

    private static void sendObjectsToServer(User[] users, ObjectOutputStream objectOutputStream) throws IOException {
        for (User someUser : users) {
            objectOutputStream.writeObject(someUser);
            objectOutputStream.flush();
            System.out.println("Object " + someUser + " was sent to Server");
            logger.info("Object " + someUser + " was sent to Server");
        }
    }

    private static void getChangedUsersFromServer(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object object;
        while ((object = objectInputStream.readObject()) != null) {
            User user = (User) object;
            System.out.println("Object " + user + " was received from Server");
            logger.info("Object " + user + " was received from Server");
        }
    }
}
