package ccr.eventbus;

/**
 * Created by DELL on 8/3/2016.
 */
public class MessageFragmentEvent {

    private String message;

    public MessageFragmentEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
