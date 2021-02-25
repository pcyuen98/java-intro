package advance;

import java.util.ArrayList;

public class ArrayListSyncMethod {
	static ArrayList<Object> a = new ArrayList<Object>(1);

	public static void main(String[] args) throws Exception {
		Thread t1 = new Thread() {
			public void run() {
				Object x = null;
				while (true) {
					if (a.size() > 0) {
						Object y = remove();
						if (x == y)
							System.out.println("Duplicate!" + a.size());
						x = y;
					}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					addList(new Object());
				}
			}
		};

		t2.start();
		Thread.sleep(100);
		t1.start();
	}

	// without synchronized will see duplicate items
	public static synchronized void addList(Object obj) {
		a.add(obj);
	}

	// without synchronized will see duplicate items
	public static synchronized Object remove() {
		return a.remove(0);
	}
}
