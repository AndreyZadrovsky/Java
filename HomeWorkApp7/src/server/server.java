package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class server {private Vector<ClientHandler> clients;

    public server() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            AuthService.connect();
//            AuthService.addUser("login1", "pass1", "nick1");
//            AuthService.addUser("login2", "pass2", "nick2");
//            AuthService.addUser("login3", "pass3", "nick3");
            server = new ServerSocket(5000);
            System.out.println("Сервер запущен!");
            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился!");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void Subscribe(ClientHandler client) {
        clients.add(client);
        broadcastClientsList();
    }

    public void Unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastClientsList();
    }

    public void BroadcastMsg(ClientHandler from, String msg) {
        for (ClientHandler o : clients) {
            if (!o.checkBlackList(from.getNick())) {
                o.SendMsg(msg);
            }
        }
    }

    public boolean isNameBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public void sendPersonalMsg(ClientHandler from, String nickTo, String msg) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nickTo)) {
                o.SendMsg("from " + from.getNick() + ": " + msg);
                from.SendMsg("to " + nickTo + ": " + msg);
                return;
            }
        }
        from.SendMsg("Клиент с ником " + nickTo + " не найден в чате");
    }

    public void broadcastClientsList() {
        StringBuilder sb = new StringBuilder();
        sb.append("/clientslist ");
        for (ClientHandler o : clients) {
            sb.append(o.getNick() + " ");
        }
        String out = sb.toString();
        for (ClientHandler o : clients) {
            o.SendMsg(out);
        }
    }
    }


