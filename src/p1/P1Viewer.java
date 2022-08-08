package p1;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class P1Viewer extends Viewer  {
    private MessageManager messageManager;

    public P1Viewer(MessageManager messageManager,int width, int height) {
        super(width, height);
        this.messageManager=messageManager;
    }

}
