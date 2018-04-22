package Visitor;

public class App {

	public static void main(String[] args) {
		Node node = new Node(5);
		node.left = new Node(3);
		node.right = new Node(1);
		
		node.accept(new Visitor());
	}

}
