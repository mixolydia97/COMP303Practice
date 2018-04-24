import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
	private static Stack<String> stack = new Stack<String>();
	
	private static ReentrantLock lock = new ReentrantLock();
	private static Condition notFull = lock.newCondition();
	private static Condition notEmpty = lock.newCondition();
	

	public static void main(String[] args) {
		//1.) Initialize the classes that implement runnable
		Producer p = new Producer(stack, lock, notFull, notEmpty);
		Consumer c = new Consumer(stack, lock, notFull, notEmpty);
		
		//2.) Make a thread for each runnable object
		Thread pThread = new Thread(p);
		Thread cThread = new Thread(c);
		
		//3.) Start each thread
		pThread.start();
		cThread.start();
	}

}


class Producer implements Runnable {
	private Stack<String> stack;
	private ReentrantLock lock;
	private Condition notFull;
	private Condition notEmpty;
	
	public Producer(Stack<String> stack, ReentrantLock lock, Condition notFull, Condition notEmpty) {
		this.stack = stack;
		this.lock = lock;
		this.notFull = notFull;
		this.notEmpty = notEmpty;
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			lock.lock();
			try {
				if(stack.size() == 5) {
					notFull.await();
				}
				
				String item = "Hello";
				System.out.format("Produced %s\n", item);
				stack.push(item);
			} catch(InterruptedException e) {
				
			} finally {
				notEmpty.signal();
				lock.unlock();
			}
		} 
	}
}
	
class Consumer implements Runnable {
	private Stack<String> stack;
	private ReentrantLock lock;
	private Condition notFull;
	private Condition notEmpty;

	public Consumer(Stack<String> stack, ReentrantLock lock, Condition notFull, Condition notEmpty) {
		this.stack = stack;
		this.lock = lock;
		this.notFull = notFull;
		this.notEmpty = notEmpty;
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			lock.lock();
			try {
				if(stack.size() == 0) {
					notEmpty.await();
				}
				String item = stack.pop();
				
				System.out.format("Consumed %s\n", item);
			} catch(InterruptedException e) {

			} finally {
				notFull.signal();
				lock.unlock();
			}
		} 
	}
}