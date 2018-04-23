package TemplateMethod;

public class TeenageGreeter extends Greeter {

	@Override
	protected void sayHello() {
		System.out.println("Hi there");

	}

	@Override
	protected void askHowTheyAre() {
		System.out.println("What's up?");

	}

	@Override
	protected void sayGoodbye() {
		System.out.println("See ya");

	}

}
