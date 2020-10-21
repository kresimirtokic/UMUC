
public class RunnableObject implements Runnable {

	private int threadNum;

	// constructor
	public RunnableObject(int threadNum) {
		this.threadNum = threadNum;

	}

	@Override
	public void run() {
		for (int counter = 1; counter <= 5; counter++) {
			System.out.println("Thread " + threadNum + " - iteration no. " + counter);
			try {
				Thread.currentThread();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}

		}
	}

}
