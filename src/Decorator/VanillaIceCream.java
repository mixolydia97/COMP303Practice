package Decorator;

public class VanillaIceCream extends IceCream {

	/**
	 * Values for the cost and calories are hard-coded
	 * @param scoops
	 */
	public VanillaIceCream(int scoops) {
		this.costPerScoop = 0.85f;
		this.caloriesPerScoop = 90;
		this.scoops = scoops;
	}

}
