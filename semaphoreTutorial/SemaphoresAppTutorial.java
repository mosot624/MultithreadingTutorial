package semaphoreTutorial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SemaphoresAppTutorial {

	public static void main(String[] args) throws Exception{
		Connection.getInstance().connect();
		
		ExecutorService exser1 = Executors.newCachedThreadPool();
		
		for(int i =0; i<200; i++){
			exser1.submit(new Runnable(){

				@Override
				public void run() {
					Connection.getInstance().conncetors();

				}
				
			});
		}
		
		exser1.shutdown();
		
		exser1.awaitTermination(1, TimeUnit.DAYS);
		
	}

}
