package com.company;

import com.company.auth.AuthService;
import com.company.auth.BaseAuthService;
import com.company.client.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class NetworkServer {
    private final int port;
    private final List<ClientHandler> clients = new ArrayList<>();
    private final AuthService authService;

    public NetworkServer(int port) {
        this.port = port;
        this.authService =  new BaseAuthService();
    }

    public void start() {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер был успешно запущен на порту " + port);
            authService.start();
            while (true){
                System.out.println("Ожидание клиентского подключения...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключился");
                // ClientHandler - Логика подключения клиентов с которыми работаем
                // clients.add(new ClientHandler(this, clientSocket));
                createClientHandler(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе сервера");
            e.printStackTrace();
        } finally {
            authService.stop();
        }
    }

    private void createClientHandler(Socket clientSocket) {
        ClientHandler clientHandler = new ClientHandler(this, clientSocket);
        clientHandler.run();
    }

    public AuthService getAuthService(){
        return authService;
    }

    public synchronized void personalMessage(String message, String nickname) throws IOException{
        boolean flag = false;
        for(ClientHandler client : clients){
            if (nickname.equals(client.getNickname())){
                client.sendMessage(message);
                flag = true;
            }
        }
        if(flag == false){
            System.out.println("Пользователь " + nickname + " не найден");
        }
    }

    public synchronized void broadcastMessage(String message) throws IOException{
        for(ClientHandler client : clients){
            client.sendMessage(message);
        }
    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }
}
