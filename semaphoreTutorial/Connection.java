package semaphoreTutorial;

import java.util.concurrent.Semaphore;

public class Connection {
	private static Connection instance = new Connection();

	private Semaphore sem1 = new Semaphore(10);

	private int count = 0;

	private Connection() {

	}

	public static Connection getInstance() {
		return instance;
	}
	
	
	public void conncetors(){
		try {
			sem1.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			connect();
		}
		finally{
			sem1.release();
		}
	}

	public void connect() {
		try {
			sem1.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		synchronized (this) {
			count++;
			System.out.println("Current count value: " + count);
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (this) {
			count--;
			System.out.println("Current count value: " + count);
		}
		
		sem1.release();

	}

}
