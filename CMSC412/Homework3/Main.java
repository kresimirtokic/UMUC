

public class Main {


	public static void main(String[] args) {
		
		Thread MT1 = new Thread(new RunnableObject(1));
		Thread MT2 = new Thread(new RunnableObject(2));
		Thread MT3 = new Thread(new RunnableObject(3));

		
		MT1.start();
					
		try {
			Thread.currentThread();
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		
		
		MT2.start();

		try {
			Thread.currentThread();
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
		
		MT3.start();
		try {
			Thread.currentThread();
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}


		try {
			MT1.join();
			MT2.join();
			MT3.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		} 
		
		
	}


}