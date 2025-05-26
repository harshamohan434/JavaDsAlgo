package MultiThreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolPractice {
    public static void main(String[] args) {
        long[] numbers = new long[10_000_0000];
        for (int i=0; i< numbers.length;i++) numbers[i] = i * i-1;

        ForkJoinPool pool = ForkJoinPool.commonPool();
        ForkJoinSumTask task = new ForkJoinSumTask(numbers, 0, numbers.length);

        long result = pool.invoke(task);
        System.out.println("Result : "+result);
    }
}

class ForkJoinSumTask extends RecursiveTask<Long>{
    final long[] numbers;
    final int start,end;
    private static final int threshold = 500;

    public ForkJoinSumTask(long[] numbers, int start, int end){
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int diff = end - start;
        if (diff <= threshold){
            long sum = 0;
            for (int i = start; i<end;i++) sum+=numbers[i];
            return sum;
        }

        int mid = (start+end)/2;

        ForkJoinSumTask leftTask = new ForkJoinSumTask(numbers, start, mid);
        ForkJoinSumTask rightTask = new ForkJoinSumTask(numbers, mid, end);

        leftTask.fork();
//        rightTask.fork();

        Long rightResult = rightTask.compute();
        Long leftResut = leftTask.join();

        return rightResult+leftResut;
    }
}
