package Decorator;

public class Oreos extends DessertTopping {

	public Oreos(Dessert dessert) {
		super(dessert);
		setCost(0.75f);
		this.name = "oreos";
	}

}
