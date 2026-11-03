package brainycode.java5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        System.out.println("Submitting task...");

        Future<Integer> result = pool.submit(() -> {
           System.out.println("Task running on: " + Thread.currentThread().getName());
           Thread.sleep(1000);  // simulate work
            return 42;
        });

        System.out.println("Main thread continues...");

        Integer value = result.get();   // waits for task to finish

        System.out.println("Result = " + value);
        pool.shutdown();

    }
}
