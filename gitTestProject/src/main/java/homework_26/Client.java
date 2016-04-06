package homework_26;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Client {
    private Socket socket;
    private int port;

    public Client(Socket socket, int port) {
        this.socket = socket;
        this.port = port;
    }

    public static void main(String[] args) throws IOException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        Socket socket = new Socket(inetAddress, 5959);

        ClientTask clientTask1 = new ClientTask(socket, 100);
        ClientTask clientTask2 = new ClientTask(socket, 50);
        ClientTask clientTask3 = new ClientTask(socket, 200);

        FutureTask futureTask1 = new FutureTask(clientTask1);
        FutureTask futureTask2 = new FutureTask(clientTask2);
        FutureTask futureTask3 = new FutureTask(clientTask3);

        ExecutorService service = Executors.newFixedThreadPool(3);

        service.execute(futureTask1);
        service.execute(futureTask2);
        service.execute(futureTask3);

        if (futureTask1.isDone() && futureTask2.isDone()) {
            service.shutdown();
        }
    }
}

