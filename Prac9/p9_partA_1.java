class Counter {
    int count = 0;

    void increment() {
        int temp = count;
        Thread.yield();
        count = temp + 1;
    }

    synchronized void safeIncrement() {
        count++;
    }
}

public class p9_partA_1 {
    public static void main(String[] args)
            throws InterruptedException {

        int numberOfThreads = 5;
        int incrementsPerThread = 10000;
        int expectedCount = numberOfThreads * incrementsPerThread;

        Counter counter1 = new Counter();
        Thread[] threads1 = new Thread[numberOfThreads];

        System.out.println("Part A: Without Synchronization");

        for (int i = 0; i < numberOfThreads; i++) {
            threads1[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter1.increment();
                }
            });
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads1[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads1[i].join();
        }

        System.out.println("Expected count: " + expectedCount);
        System.out.println("Actual count: " + counter1.count);

        Counter counter2 = new Counter();
        Thread[] threads2 = new Thread[numberOfThreads];

        System.out.println("\nPart B: With Synchronization");

        for (int i = 0; i < numberOfThreads; i++) {
            threads2[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter2.safeIncrement();
                }
            });
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads2[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads2[i].join();
        }

        System.out.println("Expected count: " + expectedCount);
        System.out.println("Actual count: " + counter2.count);
    }
}
