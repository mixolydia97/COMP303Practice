package EggCarton;

public class EggMain {

	/**
	 * I'm too lazy to deal with Scanners right now, maybe later
	 * @param args
	 */
	public static void main(String[] args) {
		Carton dozen = new Carton(12);
		
		Carton halfDozen = new Carton(6);
		
		for(int i = 0; i < halfDozen.getSize(); i++) {
			halfDozen.add(new Egg());
		}
		
		halfDozen.drop();
		
		dozen.add(halfDozen);
		
		dozen.add(new Egg());
		
		dozen.printStatus();
	}

}
