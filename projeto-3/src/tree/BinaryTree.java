package tree;

public class BinaryTree {
	
	class Node {
		int value;
		Node leftChild = null;
		Node rightChild = null;
		Node(int value) {
			this.value = value;
		}
	}
	
	protected Node root = null;
	
	public void inOrderTraversal(Node n) {
		if (n == null) return;
		inOrderTraversal(n.leftChild);
		visit(n);
		inOrderTraversal(n.rightChild);
	}
	
	private void visit(Node n) {
		System.out.println(n.value);
	}

	public boolean binaryTreeSearch(Node n, int val) {
		if (n == null) return false;
		
		if (n.value == val) {
			return true;
		} else if (n.value > val) {
			return binaryTreeSearch(n.leftChild, val);
		} else {
			return binaryTreeSearch(n.rightChild, val);
		}
	}
	
	public boolean add(Node n, int val) {
		if (n.value == val) {
			return false;
		} else if (n.value > val) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			}
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			}
		}
	}
	
	public boolean remove(Node n, Node parent, int val) {
		if (n == null) return false;
		
		if (val < n.value) {
			return remove(n.leftChild, n, val);
		} else if (val > n.value) {
			return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null) {
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, val);
			} else if (parent.leftChild == n) {
				parent.leftChild = (n.leftChild != null) ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = (n.leftChild != null) ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	private int maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
		} else {
			return maxValue(n.rightChild);
		}
	}
	
}
