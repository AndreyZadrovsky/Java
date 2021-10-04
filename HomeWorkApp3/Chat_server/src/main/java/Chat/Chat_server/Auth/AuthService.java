package Chat.Chat_server.Auth;

import java.sql.SQLException;

public interface AuthService {
    void connect() throws SQLException;
    void disconnect();
    void start();
    void stop();
    String getNicknameByLoginAndPassword(String login, String password);
    String changeNickname(String oldNick, String newNick);
    void changePassword(String nickname, String oldPassword, String newPassord);
    void createNewUser(String login, String password, String nickname);
    void deleteUser(String nickname);

}
