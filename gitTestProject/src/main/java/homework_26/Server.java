package homework_26;

        import java.io.IOException;
        import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5959);
        while (true) {
            ClientHandler clientHandler = new ClientHandler(serverSocket.accept(), 5959);
            clientHandler.start();
        }
    }
}

