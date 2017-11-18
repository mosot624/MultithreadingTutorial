package threadPoolTutorial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
	private int id;
	
	public Processor(int id){
		this.id = id;
	}
	
	
	
	@Override
	public void run() {
		System.out.println("Starting " + id);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed " + id);
	}
}

public class ThreadPoolTutor {

	public static void main(String[] args) {
		ExecutorService executor1 = Executors.newFixedThreadPool(5);
		
		for(int i = 0 ; i<5;i++){
			executor1.submit(new Processor(i));
		}
		
		executor1.shutdown();		
		
		System.out.println("All tasks submitted.");
		try {
			executor1.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("All task completed");
		
	}

}
