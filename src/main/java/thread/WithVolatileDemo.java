package thread;

//The volatile keyword ensures:
// Visibility: All threads see the latest value.
// Prevents caching optimizations or reordering that hide updates.

public class WithVolatileDemo {
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("Thread started");
            while (running) {
                // Busy wait
            }
            System.out.println("Thread stopped");
        });

        thread.start();
        Thread.sleep(1000);
        running = false; // Main thread updates the flag
        System.out.println("Flag set to false");
    }
}