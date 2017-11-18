package countdownLatchesTutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class processor implements Runnable{
	private CountDownLatch latch;
	
	public processor(CountDownLatch latch){
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("Started");
		
		latch.countDown();
	}
	
}


public class LatchesTutorial {

	public static void main(String[] args) {
		CountDownLatch latch1 = new CountDownLatch(3);
		
		ExecutorService exe1 = Executors.newFixedThreadPool(2);
		
		for(int i = 0; i<3;i++){
			exe1.submit(new processor(latch1));
		}
		
		try {
			latch1.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed");
	}

}
