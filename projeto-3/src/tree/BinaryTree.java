package tree;

public class BinaryTree {
	
	class Node {
		int value;
		Node leftChild = null;
		Node rightCild = null;
		Node(int value) {
			this.value = value;
		}
	}
	
	protected Node root = null;
	
	public void inOrderTraversal(Node n) {
		if (n == null) return;
		inOrderTraversal(n.leftChild);
		visit(n);
		inOrderTraversal(n.rightCild);
	}
	
	public void visit(Node n) {
		System.out.println(n.value);
	}

	
}
