package p1;

import javax.swing.*;
import java.io.*;

public class ObjectfileProducer implements MessageProducer {

    private Message[] messages;
    private int delay = 0;
    private int times = 0;
    private int size;
    private int currentIndex = -1;

    public ObjectfileProducer(String filename){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));

            this.times = ois.readInt();
            this.delay= ois.readInt();
            this.size= ois.readInt();
            System.out.println(times);
            System.out.println(delay);
            System.out.println(size);

            messages=new Message[size];

            for (int i = 0; i < size; i++) {
                messages[i]= (Message) ois.readObject();
                System.out.println(messages[i].getText());
            }


            } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    @Override
    public int delay() {
        return delay;
    }

    @Override
    public int times() {
        return times;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Message nextMessage() {
        if(size()==0)
            return null;
        currentIndex = (currentIndex+1) % messages.length;
        return messages[currentIndex];
    }
}
