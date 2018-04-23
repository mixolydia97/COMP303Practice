package TemplateMethod;

public class PoshGreeter extends Greeter {

	@Override
	protected void sayHello() {
		System.out.println("Hello, sir");
	}

	@Override
	protected void askHowTheyAre() {
		System.out.println("I trust that you are in good health?");
	}

	@Override
	protected void sayGoodbye() {
		System.out.println("I beg your pardon, I must leave");
	}

}
