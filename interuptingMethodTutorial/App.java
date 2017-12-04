package interuptingMethodTutorial;

import java.util.Random;

public class App {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Start");
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				//Random ran1 = new Random();

				for (int i = 0; i < 100; i++) {
					/*if (Thread.currentThread().isInterrupted()) {
						System.out.println("Interupted!");
						break;
					}
					Math.sin(ran1.nextDouble());*/

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						System.out.println("Interupted!");
						break;
						
					}
				}
				System.out.println("Hello");
			}

		});
		long l = System.currentTimeMillis();
		t1.start();

		//Thread.sleep(100);

		t1.interrupt();

		t1.join();
		
		System.out.println("Finnished");
		long c = System.currentTimeMillis() - l;
		
		System.out.println(c + " ms");

	}

}
