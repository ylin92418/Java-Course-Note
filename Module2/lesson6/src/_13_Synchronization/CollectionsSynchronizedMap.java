package _13_Synchronization;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CollectionsSynchronizedMap {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Map<String, Integer> votes = Collections.synchronizedMap(new HashMap<>());

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
    }
}
