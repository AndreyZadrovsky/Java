package Chat.Chat_app.Net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class NetworkService {
    private final static String HOST = "localhost";
    private final static int PORT = 5050;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ChatMessageService chatMessageService;

    public NetworkService(ChatMessageService chatMessageService) throws IOException {
        this.chatMessageService = chatMessageService;
        this.socket = new Socket(HOST, PORT);
        this.out = new DataOutputStream(socket.getOutputStream());
        this.in = new DataInputStream(socket.getInputStream());
    }

    public void readMessages(){
        Thread t = new Thread(()->{
           while(!Thread.currentThread().isInterrupted()){
               try {
                   String message = in.readUTF();
                   chatMessageService.receive(message);
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        });
        t.setDaemon(true);
        t.start();
    }
    public void sendMessage(String message){
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Socket getSocket() {
        return socket;
    }
}
