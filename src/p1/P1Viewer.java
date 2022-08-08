package p1;



public class P1Viewer implements ViewListener  {
    private MessageManager messageManager;
    private Viewer viewer;

    public Viewer getViewer() {
        return viewer;
    }

    public P1Viewer(Viewer viewer, MessageManager messageManager) {

        this.viewer=viewer;
        this.messageManager=messageManager;

         messageManager.addListener(this);
    }



    public void messagetransfer(Message testar) {
        try {
            viewer.setMessage(testar);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


