package homework_23_Threads;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializableInThreads {
    private static boolean ready = false;
    private static File file;
    private static SerializableObject object;

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("");
        System.out.println(path.toAbsolutePath());
        file = new File(path.toAbsolutePath() + "/ThreadsSerial.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        object = new SerializableObject("User #1", "Loginov", 11);

        WriteThread writeThread = new WriteThread();
        ReadThread readThread = new ReadThread();
        writeThread.start();
        readThread.start();
    }

    static class WriteThread extends Thread {
        public void run() {
            try {
                System.out.println("WriteThread step 1");
                synchronized (file) {
                    System.out.println("WriteThread step 2");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
                    objectOutputStream.writeObject(object);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    ready = true;
                    file.notifyAll();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class ReadThread extends Thread {
        public void run() {
            try {
                System.out.println("ReadThread step 1");
                synchronized (file) {
                    if (!ready) {
                        file.wait();
                    }
                    System.out.println("ReadThread step 2");
                    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    Object o = objectInputStream.readObject();
                    System.out.println(o);
                    objectInputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}