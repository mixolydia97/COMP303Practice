import java.util.concurrent.locks.ReentrantLock;

public class Count implements Runnable {
	
	private static int one = 0;
	private static int two = 0;
	private static int three = 0;
	private static ReentrantLock lock = new ReentrantLock();
	private int programID;
	
	public Count(int ID) {
		programID = ID;
	}

	public static void main(String[] args) {
		Thread first = new Thread(new Count(1));
		Thread second = new Thread(new Count(2));
		Thread third = new Thread(new Count(3));
		
		try {
			first.start();
			second.start();
			third.start();
			
			first.join();
			second.join();
			third.join();
		} catch (InterruptedException e) {
			//what should we do here?
			e.printStackTrace();
		} finally {
			results();
		}
		
		
	}

	public static void action(int programID) {

		if((one + two + three) >= 30) {
			return;
		}
		
		switch(programID) {
			case 1:	one++;
					break;
			case 2:	two++;
					break;
			case 3: three++;
					break;
			default: throw new IllegalArgumentException();
		}
	}
	
	public void run() {
		int sum;
		
		do {
			lock.lock();
			
			/**
			 * This seems like a Java idiom because of InterruptExceptions.
			 * We want to make sure that if an exception happens, we'll 
			 * still unlock the lock.
			 */
			try {
				action(programID);
				sum = one + two + three;
			} finally {
				lock.unlock();
			}
		} while (sum < 30);
	}
	
	private static void results() {
		System.out.printf("One = %d, Two = %d, Three = %d", one, two, three);
	}
}
