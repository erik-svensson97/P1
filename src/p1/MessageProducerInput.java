package p1;

public class MessageProducerInput {
    Buffer<MessageProducer> producerBuffer;


    public MessageProducerInput(Buffer<MessageProducer> producerBuffer){
        this.producerBuffer=producerBuffer;

    }

    public void addMessageProducer(MessageProducer m){
        producerBuffer.put(m);

    }
}
