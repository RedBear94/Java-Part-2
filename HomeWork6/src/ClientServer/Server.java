package ClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static String strFromClient;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String strFromServer = scanner.nextLine();
                        out.writeUTF("Server: " + strFromServer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            while (true) {
                strFromClient = in.readUTF();
                if (strFromClient.equals("/end")) {
                    break;
                }
                System.out.println(strFromClient);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
