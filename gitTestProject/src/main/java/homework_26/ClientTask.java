package homework_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.Callable;

public class ClientTask implements Callable<String> {
    Socket socket;
    private long timeForWait;

    public ClientTask(Socket socket, long timeForWait) {
        this.socket = socket;
        this.timeForWait = timeForWait;
    }

    public String call() throws Exception {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader readerFromConsole = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("currentThread(): " + Thread.currentThread().getName());
                String message = readerFromConsole.readLine();//считываю сообщение с клавиатуры
                printWriter.println(message);//ушло на сервер от клиента
                printWriter.flush();
                String msgFromServer = bufferedReader.readLine();
                //пробуем считать ответ от сервера(принять сообщение от хендлера)
                System.out.println("Client -> message from handler is: " + msgFromServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
