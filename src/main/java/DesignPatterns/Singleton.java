package DesignPatterns;

public class Singleton {
    public static void main(String[] args) {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.increment();
        System.out.println(enumSingleton.getCount());
    }
}

enum EnumSingleton{
    INSTANCE;

    private int count = 0;

    public void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }

}

class ThreadSafeSingleton{
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){}

    public static ThreadSafeSingleton getInstance(){
        if (instance == null){
            synchronized (ThreadSafeSingleton.class){
                if (instance == null){
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
