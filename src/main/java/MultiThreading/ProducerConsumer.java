package MultiThreading;

public class ProducerConsumer{
    public static void main(String[] args) {
        BoundedBuffer boundedBuffer = new BoundedBuffer(5);

        Runnable producer = () -> {
            for (int i =0; i<20; i++){
                try {
                    boundedBuffer.producer(i);
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        };

        Runnable consumer = () -> {
            for (int i=0;i<20;i++){
                try {
                    boundedBuffer.consumer();
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
    
}
