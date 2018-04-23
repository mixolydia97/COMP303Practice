package TemplateMethod;

public abstract class Greeter {
	protected abstract void sayHello();
	protected abstract void askHowTheyAre();
	protected abstract void sayGoodbye();
	
	public void meetSomeone() {
		sayHello();
		askHowTheyAre();
		sayGoodbye();
	}
}
