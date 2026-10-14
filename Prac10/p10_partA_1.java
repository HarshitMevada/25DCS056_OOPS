import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class p10_partA_1 {
    public static void main(String[] args)
            throws InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            final int id = i;

            pool.submit(() -> {
                System.out.println("Task " + id + " executed by "
                        + Thread.currentThread().getName());

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        pool.shutdown();

        if (pool.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("All tasks completed.");
        }
    }
}
