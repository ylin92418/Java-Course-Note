package _13_Synchronization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WithoutSynchronized {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HashMap<String, Integer> votes = new HashMap<>();

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

    }
}
