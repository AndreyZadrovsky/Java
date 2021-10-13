package Chat.Chat_server.Error;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongCredentialsException extends RuntimeException{
    private static  final Logger log = (Logger) LogManager.getLogger();
    public WrongCredentialsException(String message) {
        super(message);
        log.error(message);
    }
}
