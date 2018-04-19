package Decorator;

public class Fudge extends DessertTopping {

	public Fudge(Dessert dessert) {
		super(dessert);
		setCost(0.75f);
		this.name = "fudge";
	}

}
