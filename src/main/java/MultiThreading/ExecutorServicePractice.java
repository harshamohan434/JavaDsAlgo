package MultiThreading;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServicePractice {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> urls = Arrays.asList("url1","url2","url3","url4");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<String>> tasks = new ArrayList<>();

        for (String url : urls){
            String u = url;
            tasks.add(() -> getMetadata(u));
        }

        List<Future<String>> futures = executorService.invokeAll(tasks);

        for (Future<String> future : futures){
            try {
                String response = future.get();
                System.out.println("response : "+response);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } finally {
                executorService.shutdown();
            }
        }
    }

    static String getMetadata(String url){
        long start = System.nanoTime();
        try{
            URL url1 = new URL(url);
            String title = "<mocked>\n"+url+"</mocked>";
            Thread.sleep(1);
            long duration = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
            return String.format("Title : %s fetched in %d ms", title, duration);
        }catch (Exception e){
            throw new RuntimeException("Fetch failed for url : "+ url);
        }
    }
}
