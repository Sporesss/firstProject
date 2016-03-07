package homework_19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();

//        DataInputStream dataInputStream = new DataInputStream(inputStream);
//        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);



        while (true) {
            Object object = objectInputStream.readObject();
            User user = (User) object;
            System.out.println(user.getName());
        }

//        Object o = null;
//        while((o = objectInputStream.readObject())!= null){
//            System.out.println(o);
//        }
//        objectInputStream.close();

//        while (true) {
//            String message = dataInputStream.readUTF();
//            System.out.println(message);
//        }




    }
}
