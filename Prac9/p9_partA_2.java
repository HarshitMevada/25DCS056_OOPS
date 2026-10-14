import java.util.concurrent.CountDownLatch;

class Booking {
    int seatsLeft = 5;
    int booked = 0;
    CountDownLatch ready = new CountDownLatch(10);
    CountDownLatch start = new CountDownLatch(1);

    void book() {
        if (seatsLeft > 0) {
            ready.countDown();

            try {
                start.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            seatsLeft--;
            booked++;
            System.out.println("Seat booked");
        } else {
            ready.countDown();
            System.out.println("No seats available");
        }
    }

    synchronized void safeBook() {
        if (seatsLeft > 0) {
            seatsLeft--;
            booked++;
            System.out.println("Seat booked");
        } else {
            System.out.println("No seats available");
        }
    }
}

public class p9_partA_2 {
    public static void main(String[] args)
            throws InterruptedException {

        int numberOfThreads = 10;

        Booking b1 = new Booking();
        Thread[] t1 = new Thread[numberOfThreads];

        System.out.println("Part A: Without Synchronization");

        for (int i = 0; i < numberOfThreads; i++) {
            t1[i] = new Thread(() -> b1.book());
            t1[i].start();
        }

        b1.ready.await();
        b1.start.countDown();

        for (Thread t : t1) {
            t.join();
        }

        System.out.println("Seats left: " + b1.seatsLeft);
        System.out.println("Successful bookings: " + b1.booked);

        Booking b2 = new Booking();
        Thread[] t2 = new Thread[numberOfThreads];

        System.out.println("\nPart B: With Synchronization");

        for (int i = 0; i < numberOfThreads; i++) {
            t2[i] = new Thread(() -> b2.safeBook());
            t2[i].start();
        }

        for (Thread t : t2) {
            t.join();
        }

        System.out.println("Seats left: " + b2.seatsLeft);
        System.out.println("Successful bookings: " + b2.booked);
    }
}
