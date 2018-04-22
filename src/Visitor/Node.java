package Visitor;

public class Node implements Visitable {
	
	public int value;
	public Node left;
	public Node right;
	
	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
		
		if(left != null) {
			left.accept(v);
		}
		
		if(right != null) {
			right.accept(v);
		}
		
	}
}
