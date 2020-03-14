package ClientServer;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private static DataInputStream in;
    private static DataOutputStream out;
    private static Socket socket;
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print client name: ");
        String name = scanner.nextLine();

        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String strFromClient = scanner.nextLine();
                        if (strFromClient.equalsIgnoreCase("/end")) {
                            closeConnection();
                            break;
                        }
                        out.writeUTF(name + ": " +strFromClient);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            try {
                while (true) {
                    String strFromServer = in.readUTF();
                    System.out.println(strFromServer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
