package p1;


public class Producer {
    ProducerThread thread;
    Buffer<MessageProducer> prodBuffer;
    Buffer<Message> messageBuffer;


    public Producer(Buffer<MessageProducer> prodBuffer,
                    Buffer<Message> messageBuffer) {
        this.prodBuffer=prodBuffer;
        this.messageBuffer=messageBuffer;
    }

    public void start() {

        if( thread == null ) {
            thread = new ProducerThread(prodBuffer, messageBuffer);
            thread.start();
        }
    }


    class ProducerThread extends Thread {
        private Buffer<MessageProducer> producerBuffer;
        private Buffer<Message> messageBuffer;

        public ProducerThread(Buffer<MessageProducer> buffer, Buffer<Message> messageBuffer) {
            this.producerBuffer = buffer;
            this.messageBuffer = messageBuffer;

        }
        public void run() {
            MessageProducer mp;

            while(!Thread.interrupted()) {
                try {
                    mp = producerBuffer.get();
                    populate(mp,messageBuffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            thread=null;
        }

        private void populate(MessageProducer producer,Buffer<Message> messageBuffer) throws InterruptedException {
            Message message;

            for(int times=0; times<producer.times(); times++) {

                for(int index = 0; index<producer.size(); index++) {
                    message = producer.nextMessage();
                    messageBuffer.put(message);
                    Thread.sleep(producer.delay());
                }
            }
        }
    }
}







