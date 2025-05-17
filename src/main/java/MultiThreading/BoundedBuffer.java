package MultiThreading;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBuffer {
    private Queue<Integer> queue;
    private int capacity;

    BoundedBuffer(int capacity){
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void producer(int item) throws InterruptedException {
        while (queue.size() == capacity){
            wait();
        }

        queue.add(item);
        System.out.println("Produced : "+ item);
        notifyAll();
    }

    public synchronized void consumer() throws InterruptedException {
        while (queue.isEmpty()){
            wait();
        }

        int item = queue.poll();
        System.out.println("consumer : "+ item);

        notifyAll();
    }

}

