package Decorator;

import java.util.Arrays;
import java.util.Scanner;

public class IceCreamShop {

	/**
	 * The number of scoops should be the first argument.
	 * The ice cream flavor name should be the second argument.
	 * 
	 * Subsequent arguments are toppings.
	 * @param args
	 */
	public static void main(String[] args) {
		int numberOfScoops = 0;
		Dessert iceCream = null;

		numberOfScoops = Integer.parseInt(args[0]);
		
		switch(args[1]) {
			case "chocolate" : 	iceCream = new ChocolateIceCream(numberOfScoops);
								break;
			case "vanilla" :		iceCream = new VanillaIceCream(numberOfScoops);
								break;
			default:				System.out.println("Sorry, we don't have that flavor");
								System.exit(1);
		}
		
		String[] toppings = Arrays.copyOfRange(args, 2, args.length);
		for(String topping : toppings) {
			switch(topping) {
				case "sprinkles" : 	iceCream = new Sprinkles(iceCream);
									break;
				case "fudge" :		iceCream = new Fudge(iceCream);
									break;
				case "oreos" : 		iceCream = new Oreos(iceCream);
									break;
				default:				System.out.println("Sorry, we don't have that topping");
			}
		}
		
		printDessertInfo(iceCream);
		System.out.println("Thank you, come again soon!");
	}
	
	private static void printDessertInfo(Dessert dessert) {
		System.out.printf("Your dessert costs %.2f\n", dessert.getCost());
		System.out.printf("Your dessert has %d calories\n", dessert.getCalories());
	}
	
}
