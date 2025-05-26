package MultiThreading;

public class SynchronizedBank {

}

class BankTransfer implements Runnable{
    Bank from;
    Bank to;
    BankTransfer(Bank from, Bank to){
        this.from = from;
        this.to = to;
    }
    @Override
    public void run() {
        synchronized (from){
            synchronized (to){
                from.withdraw(10);
                to.deposit(10);
            }
        }
    }
}

class Bank{
    int balance = 1000;

    synchronized void withdraw(int amount){
        balance -= amount;
    }

    synchronized void deposit(int amount){
        balance += amount;
    }

    synchronized int getBalance(){
        return balance;
    }
}
