package homework_19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    static byte[] byteArray;
    public static void main(String[] args) throws IOException {
        int port = 7777;
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Socket clientSocket = new Socket(inetAddress, port);

        ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
//
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);    // to change!!!
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

//        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        ObjectOutputStream objectToCharArray = new ObjectOutputStream(byteArrayOutputStream);



        User users[] = {
                new User("User #1", "Userov", 11),
                new User("User #2", "Adminov", 22),
                new User("User #3", "Loginov", 33)
        };

        for (User someUser : users) {
                objectToCharArray.writeObject(someUser);
                objectToCharArray.flush();
        }
        objectToCharArray.close();

        byte[] usersAsBytes = byteArrayOutputStream.toByteArray();
        for (byte eachByte : usersAsBytes) {
            System.out.println(eachByte);
        }


        objectOutputStream.write(usersAsBytes);
        objectOutputStream.flush();
        objectOutputStream.close();


//        User user = new User("User #1", "Userov", 11);
//        objectOutputStream.writeObject(user);
//        objectOutputStream.flush();
//
//        objectInputStream.close();
//        objectOutputStream.close();


    }
}
