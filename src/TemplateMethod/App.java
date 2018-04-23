package TemplateMethod;

public class App {

	public static void main(String[] args) {
		TeenageGreeter teen = new TeenageGreeter();
		teen.meetSomeone();
		
		PoshGreeter posh = new PoshGreeter();
		posh.meetSomeone();
	}

}
