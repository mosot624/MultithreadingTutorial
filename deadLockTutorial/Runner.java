package deadLockTutorial;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private Account1 acc1 = new Account1();
	private Account1 acc2 = new Account1();

	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	private void acquiredLock(Lock firstLock, Lock secondLock) throws InterruptedException{
		while(true){
			//if locks cant be acquired
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;

			try{
				gotFirstLock = firstLock.tryLock();
				gotSecondLock = secondLock.tryLock();
			}
			finally{
				if(gotFirstLock && gotSecondLock){
					return;
				}
				if(gotFirstLock){
					firstLock.unlock();
				}
				if(gotSecondLock){
					secondLock.unlock();
				}
				
			}
			
			Thread.sleep(1000);
		}
	}
	
	public void firstThread() throws InterruptedException {
		Random ran1 = new Random();
		for (int i = 0; i < 10000; i++) {
			acquiredLock(lock1,lock2);
			try {
				Account1.transfer(acc1, acc2, ran1.nextInt(500) + 1);
			} finally {
				lock1.unlock();
				lock2.unlock();
			}

		}
	}

	public void secondThread() throws InterruptedException {
		Random ran1 = new Random();
		for (int i = 0; i < 10000; i++) {
			acquiredLock(lock1,lock2);
			try {
				Account1.transfer(acc2, acc1, ran1.nextInt(500) + 1);
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void finnished() {
		System.out.println("Account 1 balance: " + acc1.getBalance());
		System.out.println("Account 2 balance: " + acc2.getBalance());
		System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));

	}
}
