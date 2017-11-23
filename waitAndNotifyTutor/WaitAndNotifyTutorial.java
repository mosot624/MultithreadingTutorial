package waitAndNotifyTutor;

import java.util.Scanner;

public class WaitAndNotifyTutorial {

	public void producer() throws InterruptedException{
		synchronized(this){
			System.out.println("Producer thread running");
			wait();
			System.out.println("Resumed");
		}
	}
	
	public void consumer() throws InterruptedException{
		Scanner scan1 = new Scanner(System.in);
		
		Thread.sleep(2000);
		synchronized(this){
			System.out.println("Waiting for return key");
			scan1.nextLine();
			System.out.println("Return key pressed");
			notify();
		}
	}
	
	

}
