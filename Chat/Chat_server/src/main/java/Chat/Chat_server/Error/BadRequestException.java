package Chat.Chat_server.Error;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BadRequestException extends RuntimeException{
    private static  final Logger log = (Logger) LogManager.getLogger();
    public BadRequestException(String message) {
        super(message);
    }
}
