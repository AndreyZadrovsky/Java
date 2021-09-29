package Chat.Chat_app.Net;

import java.io.*;
import java.net.Socket;

public class SimpleSingleConsoleClient {
    private final static String HOST = "localhost";
    private final static int PORT = 5050;
    private DataInputStream in;
    private DataOutputStream out;
    private Thread clientConsoleThread;

    public static void main(String[] args) {
        new SimpleSingleConsoleClient().start();
    }

    private void start() {
        try(Socket socket = new Socket(HOST, PORT)){
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            startClientConsoleThread();

            while (true){
                String message = in.readUTF();
                if (message.startsWith("/end")) {
                    shutdown();
                    break;
                }
                System.out.println("Получено: " + message);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void shutdown() throws IOException {
        if(clientConsoleThread.isAlive()) clientConsoleThread.isInterrupted();
        System.out.println("Client stopped");
    }

    private void startClientConsoleThread() {
        clientConsoleThread = new Thread(()->{
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
                System.out.print("Введите сообщение для сервера >>>> \n");
                while (!Thread.currentThread().isInterrupted()){
                    if(bufferedReader.ready()){
                        String serverMessage = bufferedReader.readLine();
                        out.writeUTF(serverMessage);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        clientConsoleThread.start();
    }
}
