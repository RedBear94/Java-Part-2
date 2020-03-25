package com.company.client;

import com.company.NetworkServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private final NetworkServer networkServer;
    private final Socket clientSocket;

    private DataInputStream in;
    private DataOutputStream out;

    private String nickname;

    public ClientHandler(NetworkServer networkServer, Socket socket) {
        this.networkServer = networkServer;
        this.clientSocket = socket;
        // doHandle(socket);
    }

    private void doHandle(Socket socket) {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() ->{
                try {
                    authentication();
                    readMessages();
                } catch (IOException e){
                    System.out.println("Соеденинение с клиентом " + nickname + " было закрыто!");
                } finally {
                    closeConnection();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        networkServer.unsubscribe(this);
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMessages() throws IOException {
        while (true){
            String message = in.readUTF();
            System.out.printf("От %s: %s%n", nickname, message);
            if("/end".equals(message)){
                return;
            }
            if(message.startsWith("/w")){
                String[] messageParts = message.split("\\s+", 3);
                networkServer.personalMessage(nickname + ": " + messageParts[2], messageParts[1]);
                // System.out.println(messageParts[2]);
            } else {
                networkServer.broadcastMessage(nickname + ": " + message);
            }
        }
    }

    private void authentication() throws IOException {
        while (true){
            String message = in.readUTF();
            System.out.println(message);

            // "/auth login password"
            if (message.startsWith("/auth")) {
                // regex - регулярное выражение: s - пробел; + - пробел 1 или несколько
                // limit - число частей оазделенных в строке
                String[] messageParts = message.split("\\s+", 3);
                String login = messageParts[1];
                String password = messageParts[2];
                String username = networkServer.getAuthService().getUsernameByLoginAndPassword(login, password);

                System.out.println(username);

                if (username == null) {
                    sendMessage("Отсутвует учетная запись по данному логину и паролю");
                } else {
                    nickname = username;
                    networkServer.broadcastMessage(nickname + " зашел в чат!");
                    sendMessage("/auth " + nickname);
                    networkServer.subscribe(this);
                    break;
                }
            }
        }
    }

    public void sendMessage(String message) throws IOException{
        out.writeUTF(message);
    }

    public void run() {
        doHandle(clientSocket);
    }

    public String getNickname() {
        return nickname;
    }
}
