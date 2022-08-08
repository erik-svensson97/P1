package p1;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class P1Viewer extends Viewer  {
    private MessageManager messageManager;

    public P1Viewer(MessageManager messageManager,int width, int height) {
        super(width, height);
        this.messageManager=messageManager;
        messageManager.addPropertyChangeListener((PropertyChangeListener) this);

    }

    private class WindowUpdater implements PropertyChangeListener{
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    if(evt.getPropertyName().equals("game") &&
                            evt.getNewValue() instanceof Message) {

                        Message message = (Message) evt.getNewValue();

                    }
                }
            });
        }
    }
}
