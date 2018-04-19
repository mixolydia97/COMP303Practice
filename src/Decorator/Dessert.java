package Decorator;

/**
 * The "idea" of a dessert you might buy. Provides commonality 
 * between the base class and the decorator classes.
 * @author sarah
 *
 */
public interface Dessert {
	
	public double getCost();
	
	public void setCost(double newCost);
	
	public int getCalories();
	
	public String getName();
	
}
