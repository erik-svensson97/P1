package p1;



public class P1Viewer   {
    private MessageManager messageManager;
    private Viewer viewer;

    public Viewer getViewer() {
        return viewer;
    }

    public P1Viewer(Viewer viewer, MessageManager messageManager) {
        this.viewer=viewer;
        this.messageManager=messageManager;

        messageManager.addListener(this::messagetransfer);
    }

    public void messagetransfer() {
        try {
            viewer.setMessage(messageManager.getMessageBuffer().get());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


