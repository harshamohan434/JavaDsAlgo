package MultiThreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockUsuage {
}

class SafeTransfer implements Runnable{

    private final ReentrantLockBank from;

    private final ReentrantLockBank to;

    public SafeTransfer(ReentrantLockBank from, ReentrantLockBank to){
        this.from = from;
        this.to = to;
    }

    @Override
    public void run() {
        if (from.getLock().tryLock()){
            if (to.getLock().tryLock()){
                from.withdraw(10);
                to.deposit(10);
            }
        }
    }
}

class ReentrantLockBank{
    private int balance = 10000;
    private final ReentrantLock lock = new ReentrantLock();

    void withdraw(int amount){
        lock.lock();
        try {
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    void deposit(int amount){
        lock.lock();
        try {
            balance += amount;
        }finally {
            lock.unlock();
        }
    }

    int getBalance(){
        return balance;
    }

    ReentrantLock getLock(){
        return lock;
    }
}
