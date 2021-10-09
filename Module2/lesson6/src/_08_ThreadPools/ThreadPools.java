package _08_ThreadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService cachedThreadExecutor = Executors.newCachedThreadPool();
        ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(12);

        // execute method
        //cachedThreadExecutor.execute(() -> System.out.println("execute " + Thread.currentThread().getId()));
        //cachedThreadExecutor.execute(() -> System.out.println("execute " + Thread.currentThread().getId()));
        //cachedThreadExecutor.execute(() -> System.out.println("execute " + Thread.currentThread().getId()));
    }
}
