package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientHandler {
    private server server;
    private Socket socket;
    private String nick;
    DataInputStream in;
    DataOutputStream out;
    List<String> blackList;

    public ClientHandler(server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.blackList = new ArrayList<>();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String currentNick = AuthService.getNickByLoginAndPass (tokens[1], tokens[2]);
                                if (currentNick != null) {
                                    if (!server.isNameBusy(currentNick)) {
                                        SendMsg("/authok");
                                        nick = currentNick;
                                        server.Subscribe(ClientHandler.this);
                                        break;
                                    } else {
                                        SendMsg("Учетная запись уже используется");
                                    }
                                } else {
                                    SendMsg("Неверный логин/пароль");
                                }
                            }
                        }

                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/")) {
                                if (str.equals("/end")) {
                                    out.writeUTF("/serverclosed");
                                    break;
                                }
                                if (str.startsWith("/w ")) {
                                    String[] tokens = str.split(" ", 3);
                                    server.sendPersonalMsg(ClientHandler.this, tokens[1], tokens[2]);
                                }
                                if (str.startsWith("/blacklist ")) {
                                    String[] tokens = str.split(" ");
                                    if (server.isNameBusy(tokens[1])) {
                                        if (!nick.equals(tokens[1])) {
                                            blackList.add(tokens[1]);
                                            SendMsg("Вы добавили пользователя " + tokens[1] + " в черный список");
                                        } else {
                                            SendMsg("Вы пытаетесь добавить себя в черный список");
                                        }
                                    }
                                    else{SendMsg("Такого ника нет среди участников чата" );}
                                }
                            } else {
                                server.BroadcastMsg(ClientHandler.this,nick + " " + str);
                            }
                            System.out.println("Client: " + str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
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
                        server.Unsubscribe (ClientHandler.this);
                    }

                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }

    public boolean checkBlackList(String nick) {
        return blackList.contains(nick);
    }
}
