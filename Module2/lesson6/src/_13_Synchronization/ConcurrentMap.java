package _13_Synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ConcurrentMap {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Map<String, Integer> votes = new ConcurrentHashMap<>();

        ExecutorService executor = Executors.newFixedThreadPool(12);

        List<Future> futures = new ArrayList<>();

        for (int i = 0; i < 10_000; i++) {
            futures.add(
                    executor.submit(() -> {
                        if (!votes.containsKey("Larry")) {
                            votes.put("Larry", 1);
                        } else {
                            int vote = votes.get("Larry");
                            votes.put("Larry", vote + 1);
                        }
                    })
            );
        }

        for (Future future : futures) {
            future.get();
        }

        System.out.println(votes);
        // Output: 7842, still doesn't work
        // since put and get are two separate operations,
        // ConcurrentHashMap only supports single operation (atomic operation)
    }
}
