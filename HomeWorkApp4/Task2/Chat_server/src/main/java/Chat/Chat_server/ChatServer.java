package Chat.Chat_server;

import Chat.Chat_server.Auth.AuthService;
import Chat.Chat_server.Auth.DatabaseAuthService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {
    private static final int PORT = 5050;
    private AuthService authService;
    private Map<String,ChatClientHandler> handlers;

    public ChatServer(){
        this.authService = new DatabaseAuthService();
        this.handlers = new HashMap<>();

    }

    public void start() {

        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Сервер запущен");
            while(true){
                System.out.println("Ожидаю подключения...");
                Socket socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                new ChatClientHandler(socket, this).handle();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String from, String message) {
            message = String.format("[%s]: %s",from, message);
            for (ChatClientHandler handler : handlers.values()) {
                handler.sendMessage(message);
            }
        }

    public synchronized void removeAuthorizedClientFromList(ChatClientHandler handler){
        this.handlers.remove(handler.getCurrentUser());
        sendClientsOnline();
    }

    public synchronized void addAuthorizedClientToList(ChatClientHandler handler){
        this.handlers.put(handler.getCurrentUser(),handler);
        sendClientsOnline();
    }

    public AuthService getAuthService() {
        return authService;
    }

    public void sendClientsOnline(){
        StringBuilder sb = new StringBuilder("/list:").append(ChatClientHandler.REGEX);
        for(ChatClientHandler handler : handlers.values()){
            sb.append(handler.getCurrentUser()).append(ChatClientHandler.REGEX);
        }
        String message = sb.toString();
        for (ChatClientHandler handler : handlers.values()) {
            handler.sendMessage(message);
        }
    }

    public void sendPrivateMessage(String sender, String recipient, String message, ChatClientHandler senderHandler) {
        ChatClientHandler handler = handlers.get(recipient);
        if(handler == null){
              senderHandler.sendMessage(String.format("ОШИБКА: %s получатель не найден: %s",ChatClientHandler.REGEX, recipient));
              return;
            }
        message = String.format("[%s] ->[%s]: %s", sender, recipient, message);
        handler.sendMessage(message);
        senderHandler.sendMessage(message);
    }

    public boolean isNicknameBusy(String nickname){
        return this.handlers.containsKey(nickname);
    }
}
