package Decorator;

/**
 * This is abstract so that I can make it more complicated
 * @author sarah
 *
 */
public abstract class IceCream implements Dessert {
	protected double costPerScoop;
	protected int caloriesPerScoop;
	protected int scoops;
	protected String name;
	

	public double getCost() {
		return costPerScoop * scoops;
	}
	
	public void setCost(double newCost) {
		if(newCost >= 0) {
			this.costPerScoop = newCost;
		}
	}

	public int getCalories() {
		return caloriesPerScoop * scoops;
	}
	
	public String getName() {
		return name;
	}
}
