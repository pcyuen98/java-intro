package advance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListNonThreadSafe {

	static ArrayList<Object> unsafe = new ArrayList<Object>(1);

	static List<Object> a = Collections.synchronizedList(unsafe);

	public static void main(String[] args) throws Exception {
		Thread t1 = new Thread() {
			public void run() {
				Object x = null;
				while (true) {
					if (a.size() > 0) {
						Object y = a.remove(0);
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
					a.add(new Object());
				}
			}
		};

		t2.start();
		Thread.sleep(100);
		t1.start();
	}
}
