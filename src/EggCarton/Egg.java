package EggCarton;

public class Egg implements Eggs {
	private boolean smashed;
	private int size = 1;
	
	public Egg() {
		smashed = false;
	}

	@Override
	public void drop() {
		smashed = true;
	}
	
	public int getSize() {
		return size;
	}
	
	public void printStatus() {
		System.out.format("This egg is%s intact\n", (smashed ? " not" : ""));
	}

}
