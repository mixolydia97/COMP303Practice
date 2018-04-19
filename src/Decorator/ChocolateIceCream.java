package Decorator;

public class ChocolateIceCream extends IceCream {

	/**
	 * Values for the cost and calories are hard-coded
	 * @param scoops
	 */
	public ChocolateIceCream(int scoops) {
		this.costPerScoop = 1f;
		this.caloriesPerScoop = 100;
		this.scoops = scoops;
		this.name = "chocolate";
	}
}
