package advance;

public class TaskRunner {

	// Mutual Exclusion – only one thread executes a critical section at a time
	// Visibility – changes made by one thread to the shared data are visible to
	// other threads to maintain data consistency

	private volatile static int number;
	private volatile static boolean ready;

	private static class Reader extends Thread {
		
		@Override
		public void run() {
			while (!ready) {
				Thread.yield();
			}

			System.out.println(number);
		}
	}

	public static void main(String[] args) {
		new Reader().start();
		number = 42;
		ready = true;
	}
}