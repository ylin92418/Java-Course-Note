package _13_Synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ConcurrentMapSolved {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Map<String, Integer> votes = new ConcurrentHashMap<>();

        ExecutorService executor = Executors.newFixedThreadPool(12);

        List<Future> futures = new ArrayList<>();

        for (int i = 0; i < 10_000; i++) {
            futures.add(
                    executor.submit(() -> {
                        votes.compute("Larry", (k, v) -> v == null ? 1 : v + 1);
                    })
            );
        }

        for (Future future : futures) {
            future.get();
        }

        System.out.println(votes);
        // Output: 10000, it is working!
        // votes.compute("Larry", (k, v) -> v == null ? 1 : v + 1);
        // this is an atomic operation ( read and update are in one operation)
    }
}
