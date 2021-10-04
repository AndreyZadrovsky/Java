package Chat.Chat_server.Error;

public class UserNotFoundExeption extends RuntimeException{
    public UserNotFoundExeption(String message) {
        super(message);
    }
}
