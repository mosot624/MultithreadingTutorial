package workingExampleofLowLevelSynchronization;

import java.util.LinkedList;
import java.util.Random;

public class ProducerAndConsumer {

	private LinkedList<Integer> list1 = new LinkedList<Integer>();
	private final int limit = 10;
	private Object lock1 = new Object();

	public void producer() throws InterruptedException {
		int value = 0;
		while (true) {
			synchronized (lock1) {
				while (list1.size() == limit) {
					lock1.wait();
				}
				list1.add(value++);
				lock1.notify();
			}
		}

	}

	public void consumer() throws InterruptedException {
		Random ran1 = new Random();
		
		while (true) {
			synchronized (lock1) {
				while (list1.size() == 0) {
					lock1.wait();
				}
				System.out.print("List list size is" + list1.size());
				int value = list1.removeFirst();
				System.out.println(" ;value is " + value);
				lock1.notify();
			}
			Thread.sleep(ran1.nextInt(500)+1);
		}

	}
}
