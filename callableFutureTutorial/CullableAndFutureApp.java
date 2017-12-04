package callableFutureTutorial;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CullableAndFutureApp {
	public static void main(String[] args) {
		ExecutorService ex1 = Executors.newCachedThreadPool();

		Future<?> future = ex1.submit(new Callable<Void>() {

			@Override
			public Void call() throws Exception {
				Random ran1 = new Random();

				int i = ran1.nextInt(2000);
				if(i>1000){
					throw new IOException("Sleeping for too long");
				}
				
				System.out.println("Starting");
				try {
					Thread.sleep(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Finnished");
				return null;
			}

		});

		ex1.shutdown();
		
		//ex1.awaitTermination(timeout, unit)
		
		try {
			System.out.println("Result: "+future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException except1 = (IOException) e.getCause();
			
			System.out.println(except1.getMessage());
		}
	}

}
