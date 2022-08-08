package p1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MessageManager{
    private Thread thread;
    Buffer<Message> messageBuffer;
    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);


    public MessageManager(Buffer<Message> messageBuffer){
        this.messageBuffer=messageBuffer;

    }

    public void addPropertyChangeListener( PropertyChangeListener listener ){
        changes.addPropertyChangeListener(listener);
    }

    public void start(){
        thread= new WindowUpdater(messageBuffer);
        thread.start();

    }



    private class WindowUpdater extends Thread{
        Buffer<Message> messageBuffer;
        Message message;

        public WindowUpdater(Buffer<Message> messageBuffer) {
            this.messageBuffer=messageBuffer;
        }

        @Override
        public void run() {
            while(thread!=null){
                try {
                    Thread.sleep(1000);
                    message=messageBuffer.get();
                    changes.firePropertyChange("message", null,  message);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }










}
