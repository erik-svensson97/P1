package p1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MessageManager {
    Buffer<Message> messageBuffer;
    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);


    public MessageManager(Buffer<Message> messageBuffer){
        this.messageBuffer=messageBuffer;

    }

    public void addPropertyChangeListener( PropertyChangeListener listener ){
        changes.addPropertyChangeListener(listener);
    }




}
