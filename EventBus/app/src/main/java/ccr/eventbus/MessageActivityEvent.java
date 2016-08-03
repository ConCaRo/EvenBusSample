package ccr.eventbus;

/**
 * Created by DELL on 8/3/2016.
 */
public class MessageActivityEvent {

    private String message;

    public MessageActivityEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
