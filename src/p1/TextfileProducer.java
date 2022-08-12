package p1;

import javax.swing.*;
import java.io.*;

public class TextfileProducer implements MessageProducer{

    private Message[] messages;
    private int delay = 0;
    private int times = 0;
    private int size;
    private int currentIndex = -1;

    public TextfileProducer(String filename){

        try(BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))){

            times = Integer.parseInt(br.readLine());
            delay= Integer.parseInt(br.readLine());
            size= Integer.parseInt(br.readLine());
            messages=new Message[size];

            int index = 0;
            String text = br.readLine();
            String fileName = br.readLine();

            while (text!=null){
                messages[index]= new Message(text,new ImageIcon(fileName));
                text = br.readLine();
                fileName = br.readLine();
                index++;
            }




        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * returns delay between each message
     */

    @Override
    public int delay() {
        return delay;
    }

    /**
     * returns number of times sequence of messages should be shown times
     */

    @Override
    public int times() {
        return times;
    }

    /**
     * returns size of message array
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * returns next message in array and returns to index 0 when it has itiriated trough whole array
     */

    @Override
    public Message nextMessage() {
        if(size()==0)
            return null;
        currentIndex = (currentIndex+1) % messages.length;
        return messages[currentIndex];
    }
}
