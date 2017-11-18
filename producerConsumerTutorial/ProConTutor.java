package producerConsumerTutorial;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProConTutor {
	
	private static BlockingQueue<Integer> que1 = new  ArrayBlockingQueue<Integer>(10);
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
		});
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
	
	private static void produce() throws InterruptedException{
		Random ran1 = new Random();
		while(true){
			que1.put(ran1.nextInt(100)+1);
		}
	}
	
	private static void consumer() throws InterruptedException{
		Random ran1 = new Random();
		while(true){
			Thread.sleep(100);
			
			if(ran1.nextInt(10) == 0){
				Integer value = que1.take();
				System.out.println("Taken value: "+ value + " Queue size: " + que1.size());
			}
		}
	}
	
}
