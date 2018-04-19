package Decorator;

public class Sprinkles extends DessertTopping {

	/**
	 * Sprinkles cost 50 cents
	 * @param dessert
	 */
	public Sprinkles(Dessert dessert) {
		super(dessert);
		setCost(0.5f);
		this.name = "sprinkles";
	}
}
