package workingExampleofLowLevelSynchronization;

import waitAndNotifyTutor.WaitAndNotifyTutorial;

public class TheExample {

	public static void main(String[] args) {
		ProducerAndConsumer app1 = new ProducerAndConsumer();
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
