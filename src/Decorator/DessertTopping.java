package Decorator;

public abstract class DessertTopping implements Dessert {

	protected Dessert dessert;
	protected double toppingPrice;
	protected int toppingCalories;
	
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
		// TODO Auto-generated method stub
		return dessert.getCalories() + toppingCalories;
	}

}
