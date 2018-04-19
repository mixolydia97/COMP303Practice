package Decorator;

public abstract class DessertTopping implements Dessert {

	protected Dessert dessert;
	protected double toppingPrice;
	protected int toppingCalories;
	protected String name;
	
	public DessertTopping(Dessert dessert) {
		this.dessert = dessert;
	}
	
	public double getCost() {
		return dessert.getCost() + toppingPrice;
	}

	public void setCost(double newCost) {
		if(newCost >= 0) {
			this.toppingPrice = newCost;
		}
	}

	public int getCalories() {
		return dessert.getCalories() + toppingCalories;
	}
	
	public String getName() {
		return name;
	}

}
