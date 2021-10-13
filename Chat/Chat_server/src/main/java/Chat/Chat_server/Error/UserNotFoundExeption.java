package Chat.Chat_server.Error;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserNotFoundExeption extends RuntimeException{
    private static  final Logger log = (Logger) LogManager.getLogger();
    public UserNotFoundExeption(String message) {
        super(message);
        log.error(message);
    }
}
