package waitAndNotifyTutor;

public class app {

	public static void main(String[] args) {
		WaitAndNotifyTutorial app1 = new WaitAndNotifyTutorial();
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				try {
					app1.producer();
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
					app1.consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
			
		});
		t1.start();
		t2.start();
	}

}
