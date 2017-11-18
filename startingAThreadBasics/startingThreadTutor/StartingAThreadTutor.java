package startingAThreadBasics.startingThreadTutor;

public class StartingAThreadTutor {

	public static void main(String[] args) {
		Runner run1 = new Runner();
		Runner run2 = new Runner();


		run1.start();
		run2.start();

		long end = System.currentTimeMillis();
	}

}

class Runner extends Thread {
	public void run() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			//System.out.println(i);

		}
		long end = System.currentTimeMillis();

		System.out.println((end - start) + " ms");

	}
}
