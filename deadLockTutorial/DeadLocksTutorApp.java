package deadLockTutorial;

public class DeadLocksTutorApp {

	public static void main(String[] args) {
		final Runner run1 = new Runner();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try{
					run1.firstThread();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				try{
					run1.secondThread();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		run1.finnished();
	}

}
