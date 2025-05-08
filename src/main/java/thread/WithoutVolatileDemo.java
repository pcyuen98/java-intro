package thread;

public class WithoutVolatileDemo {
    private static boolean running = true;

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