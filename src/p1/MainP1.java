package p1;

import javax.swing.ImageIcon;

public class MainP1 {
	public static void main(String[] args) {
		Buffer<Message> messageBuffer = new Buffer<Message>();
		Buffer<MessageProducer> producerBuffer	= new Buffer<MessageProducer>();
		
		MessageManager messageManager = new MessageManager(messageBuffer);
		Viewer viewer1 = new Viewer(300,200);
		Viewer viewer2 = new Viewer(300,200);
		Viewer viewer3 = new Viewer(300,200);


		P1Viewer v1 = new P1Viewer(viewer1,messageManager);
		P1Viewer v2 = new P1Viewer(viewer2,messageManager);
		P1Viewer v3 = new P1Viewer(viewer3,messageManager);

		Viewer.showPanelInFrame(v1.getViewer(), "Viewer 1", 100, 50);
		Viewer.showPanelInFrame(v2.getViewer(), "Viewer 2", 450, 50);
		Viewer.showPanelInFrame(v3.getViewer(), "Viewer 3", 800, 200);

		
		Producer producer = new Producer(producerBuffer,messageBuffer);

		
		MessageProducerInput ipManager = new MessageProducerInput(producerBuffer);		
		ipManager.addMessageProducer(getArrayProducer(1,400));
		ipManager.addMessageProducer(new ShowGubbe(3000));
		ipManager.addMessageProducer(new TextfileProducer("files/new.txt"));
		producer.start();
		messageManager.start();

	}
	
    private static ArrayProducer getArrayProducer(int times, int delay) {
    	Message[] messages = { new Message("UP",new ImageIcon("images/new1.jpg")),
    			new Message("Going down.",new ImageIcon("images/new2.jpg")),
    			new Message("Going down..",new ImageIcon("images/new3.jpg")),
    			new Message("Going down...",new ImageIcon("images/new4.jpg")),
    			new Message("Going down....",new ImageIcon("images/new5.jpg")),
    			new Message("Almost down",new ImageIcon("images/new6.jpg")),
    			new Message("DOWN",new ImageIcon("images/new7.jpg")),
    			new Message("Going up.",new ImageIcon("images/new8.jpg")),
    			new Message("Going up..",new ImageIcon("images/new9.jpg")),
    			new Message("Almost up",new ImageIcon("images/new10.jpg")) };
        return new ArrayProducer(messages,times,delay);       
    }
}

class ShowGubbe implements MessageProducer {
	private int delay;
	
	public ShowGubbe(int delay) {
		this.delay = delay;
	}

	@Override
	public int delay() {
		return delay;
	}

	@Override
	public int times() {
		return 1;
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public Message nextMessage() {
		return new Message("Hi folks...",new ImageIcon("images/gubbe.jpg"));
	}
	
}

