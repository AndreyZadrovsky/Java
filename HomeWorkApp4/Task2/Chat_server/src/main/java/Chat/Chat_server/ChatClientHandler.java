package Chat.Chat_server;

import Chat.Chat_server.Error.UserNotFoundExeption;
import Chat.Chat_server.Error.WrongCredentialsException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatClientHandler {
    public static final String REGEX = "%&%";
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Thread handlerThread;
    private ChatServer server;
    private String currentUser;
    private ExecutorService service = Executors.newCachedThreadPool();

    public ChatClientHandler(Socket socket, ChatServer server) {
        try {
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Обработчик создан");
            this.server = server;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handle() {
        service.execute(()->{
            authorize();
            try {
            while (!Thread.currentThread().isInterrupted() && socket.isConnected()) {
                String message = in.readUTF();
                handleMessage(message);
            }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    server.removeAuthorizedClientFromList(this);
                    service.shutdown();
                }

        });
    }
//auth:llll pppp
    private void authorize(){
        while (true){
            try {
                String message = in.readUTF();
                if (message.startsWith("/auth") || message.startsWith("/register")){
                    if (handleMessage(message))break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean handleMessage(String message){
        try {
            String[] parsed = message.split(REGEX);
            switch (parsed[0]) {
                case "/w":
                    server.sendPrivateMessage(this.currentUser, parsed[1], parsed[2], this);
                    break;

                case "/ALL":
                    server.broadcastMessage(this.currentUser, parsed[1]);
                    break;

                case "/change_nick":
                    String nick = server.getAuthService().changeNickname(this.currentUser,parsed[1]);
                    server.removeAuthorizedClientFromList(this);
                    this.currentUser = nick;
                    server.addAuthorizedClientToList(this);
                    sendMessage("/change_nick_ok");
                    break;
                case "/change_pass" :
                    server.getAuthService().changePassword(this.currentUser, parsed[1], parsed[2]);
                    sendMessage("/change_pass_ok");
                    break;
                case "/remove":
                    server.getAuthService().deleteUser(this.currentUser);
                    this.socket.close();
                    break;
                case "/register":
                    server.getAuthService().createNewUser(parsed[1], parsed[2],parsed[3]);
                    sendMessage("/register_ok:");
                    break;
                case "/auth":
                    this.currentUser = server.getAuthService().getNicknameByLoginAndPassword(parsed[1], parsed[2]);
                    if(server.isNicknameBusy(currentUser)) {
                        sendMessage("Ошибка:" + REGEX + "Этот пользователь уже онлайн");
                    }else {
                        this.server.addAuthorizedClientToList(this);
                        sendMessage("authok:" + REGEX + this.currentUser);
                        return true;
                    }
                    break;
                default:
                    sendMessage("Ошибка:" + REGEX + "Команда не найдена");
            }
        } catch (Exception e) {
            sendMessage("Ошибка:" + REGEX + e.getMessage());
        }
        return false;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void sendMessage(String message) {
        try {
            this.out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
