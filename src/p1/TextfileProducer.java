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
