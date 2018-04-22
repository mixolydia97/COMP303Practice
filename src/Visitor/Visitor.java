package Visitor;

public class Visitor {
	
	/**
	 * I still don't understand the visitor very well, I'm not sure 
	 * what to do with it really.
	 * @param n
	 */
	public void visit(Node n) {
		if(n != null) {
			System.out.format("%d\n", n.value);
		}
	}
}
