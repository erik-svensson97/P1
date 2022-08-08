package p1;


import java.util.ArrayList;
import java.util.LinkedList;

public class MessageManager{

    Buffer<Message> messageBuffer;
    ArrayList<ViewListener> listeners = new ArrayList<ViewListener>();
    private MessageThread thread;


    public MessageManager(Buffer<Message> messageBuffer) {
        this.messageBuffer = messageBuffer;
    }

    public void addListener(ViewListener listener){

        listeners.add(listener);
    }

    public void start()
    {
        thread = new MessageThread();
        thread.start();
    }

    public class MessageThread extends Thread{
        public void run(){

            try{
                thread.sleep(100);

                while (!Thread.interrupted()){

                   Message testar = messageBuffer.get();

                    for (ViewListener listener : listeners)
                    {
                        listener.messagetransfer(testar);
                    }


                }

            }catch (Exception e){
            }
        }
    }

    public Buffer<Message> getMessageBuffer() {
        return messageBuffer;
    }
}
