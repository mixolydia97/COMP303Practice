package EggCarton;

import java.util.ArrayList;

/**
 * Represent a collection of eggs with a fixed size.
 * Also since this is a Composite, apparently cartons can
 * hold other, smaller cartons.
 * 
 * @author sarah
 *
 */

public class Carton implements Eggs {
	
	int maxSize;
	ArrayList<Eggs> eggs;
	
	
	public Carton(int size) {
		eggs = new ArrayList<Eggs>();
		this.maxSize = size >= 0 ? size : 0;
	}
	
	public void add(Eggs egg) {
		if(eggs.size() + egg.getSize() <= maxSize) {
			eggs.add(egg);
		}
	}

	@Override
	public void drop() {
		for(Eggs egg : eggs) {
			egg.drop();
		}
	}
	
	@Override 
	/**
	 * Even if a carton is not full, it's size is still it's max capacity
	 */
	public int getSize() {
		return maxSize;
	}
	
	@Override
	public void printStatus() {
		for(Eggs egg : eggs) {
			egg.printStatus();
		}
	}

}
