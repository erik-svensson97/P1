package p1;


import java.util.LinkedList;

public class MessageManager{

    Buffer<Message> messageBuffer;
    private ViewListener listener;
    private MessageThread thread;


    public MessageManager(Buffer<Message> messageBuffer) {
        this.messageBuffer=messageBuffer;


    }

    public void addListener(ViewListener listener){
        this.listener=listener;

    }
    public void start()
    {
        thread= new MessageThread();
        thread.start();

    }
    public class MessageThread extends Thread{
        public void run(){

            try{
                thread.sleep(100);

                while (!Thread.interrupted()){
                    listener.messagetransfer();
                }

            }catch (Exception e){
            }
        }
    }

    public Buffer<Message> getMessageBuffer() {
        return messageBuffer;
    }
}
