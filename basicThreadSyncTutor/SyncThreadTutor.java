package basicThreadSyncTutor;

import java.util.Scanner;

public class SyncThreadTutor {

	public static void main(String[] args) {
		Processor proc1 = new Processor();
		
		proc1.start();
		System.out.println("Press enter to stop");
		Scanner sc1 = new Scanner(System.in);
		sc1.nextLine();
		proc1.shutdown();
		
	}

}

class Processor extends Thread{
	private volatile boolean running = true;
	
	public void run(){
		while(running == true){
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void shutdown(){
		running = false;
	}
}