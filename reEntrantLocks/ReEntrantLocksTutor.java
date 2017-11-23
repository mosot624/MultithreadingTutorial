package reEntrantLocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLocksTutor {

	private int counter = 0;
	private Lock lock1 = new ReentrantLock();
	private Condition cond1 = lock1.newCondition();

	private void increment() {
		for (int i = 0; i < 10000; i++) {
			counter++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock1.lock();
		System.out.println("Waiting");
		
		cond1.await();
		try {
			increment();
		} finally {
			lock1.unlock();
		}
	}

	public void secondThread() throws InterruptedException {
		
		Thread.sleep(1000);
		lock1.lock();
		
		//waits for a return key
		System.out.println("Press Enter");
		new Scanner(System.in).nextLine();
		System.out.println("Enter key pressed");
		
		cond1.signal();
		try {
			increment();
		} finally {
			lock1.unlock();
		}
	}

	public void finnished() {
		System.out.println("Value of count " + counter);
	}

}
