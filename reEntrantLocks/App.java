package reEntrantLocks;

import waitAndNotifyTutor.WaitAndNotifyTutorial;

public class App {

	public static void main(String[] args) throws InterruptedException {
		ReEntrantLocksTutor app1 = new ReEntrantLocksTutor();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					app1.firstThread();
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
					app1.secondThread();
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
		
		app1.finnished();
		
		
		
	}

}
