package homework_19;

        import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.io.ObjectOutputStream;
        import java.net.ServerSocket;
        import java.net.Socket;
        import java.util.logging.Logger;

public class Server {
    static Logger logger = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(7777);
        logger.info(serverSocket.toString());
        Socket accept = serverSocket.accept();
        logger.info(accept.toString());

        ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());

        workWithObjectsFromClient(objectInputStream, objectOutputStream);

        objectInputStream.close();
        objectOutputStream.close();
    }

    private static void workWithObjectsFromClient(ObjectInputStream objectInputStream, ObjectOutputStream objectOutputStream) throws IOException, ClassNotFoundException {
        Object object;
        while ((object = objectInputStream.readObject()) != null) {
            logger.info("Object " + object + " was received from Client");
            User user = (User) object;
            System.out.println("Object " + user + " was received from Client");
            User changedUser = changeUser(user);
            sendChangedUsersToClient(changedUser, objectOutputStream);
        }
        sendChangedUsersToClient(null, objectOutputStream);
    }

    private static User changeUser(User someUser) {
        String newName = someUser.getSurname();
        String newSurname = someUser.getName();
        someUser.setName(newName);
        someUser.setSurname(newSurname);
        System.out.println("Object was changed -- > " + someUser);
        logger.info("Object was changed -- > " + someUser);
        return someUser;
    }

    private static void sendChangedUsersToClient(User someUser, ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(someUser);
        objectOutputStream.flush();
        System.out.println("Changed object was sent to Client");
        logger.info("Changed object " + someUser + " was sent to Client");
    }
}
