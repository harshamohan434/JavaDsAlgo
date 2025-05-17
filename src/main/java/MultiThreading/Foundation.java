package MultiThreading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Foundation {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

    }
}

class ReentrantLockCounter{
    int count =0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment(){
        lock.lock();
        try {
            count++;
        }catch (Exception skip){}
        finally {
            lock.unlock();
        }
    }

    public int getCount(){
        lock.lock();
        try {
            return count;
        }finally {
            lock.unlock();
        }
    }
}

class ReadWriteLockCounter{
    int count = 0;
    public final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    public void increment(){
        writeLock.lock();
        try {
            count++;
        }finally {
            writeLock.unlock();
        }
    }

    public int getCount(){
        readLock.lock();
        try {
            return count;
        }finally {
            readLock.unlock();
        }
    }
}

class SyncCounter{
    private int counter = 0;

    //synchronised is used for this method should use only by one thread which makes it atomicity
    private synchronized int getCounter(){
        return counter;
    }

    private synchronized void increment(){
        counter++;
    }
}

class VolatileFlag{
    private volatile boolean running = true;

    public void stop(){
        running = false;
    }
}

class BlockingQueuePractice{
    private void blockingQueue() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        Runnable producer = () -> {
            for (int i=0; i< 100; i++){
                try{
                    queue.put(i);
                    System.out.println("Produced : "+i);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable consumer = () -> {
            while (true){
                Integer item = null;
                try {
                    item = queue.take();
                    System.out.println("Consumed : "+ item);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }

            }
        };

        executorService.submit(producer);
        executorService.submit(consumer);

        AtomicInteger count = new AtomicInteger();

        Callable<Integer> callableTask = () -> count.getAndIncrement();

        Future<Integer> result = executorService.submit(callableTask);

        System.out.println("callable result : "+result.get());

        executorService.shutdown();

    }

}
