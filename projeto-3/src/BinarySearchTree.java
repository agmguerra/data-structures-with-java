public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (BinarySearchTree<E>.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	
	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
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
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/
	
	private Node findNode(Node n, E val) {
		if (n == null) return null;
		
		if (n.value.equals(val)) {
			return n;
		} else if (n.value.compareTo(val) > 0) {
			return findNode(n.leftChild, val);
		} else {
			return findNode(n.rightChild, val);
		}

	}
	
	
	// Method #1.
	public Node findNode(E val) {
	
		if (val == null) return null;
		Node n = findNode(root, val);
		
		return n; 

	}
	
	
	
	private int depth(Node n, int baseDepth, E val) {
		if (n == null) return -1;
		
		int depth = baseDepth;
		if (n.value.equals(val)) {
			return depth;
		} else if (n.value.compareTo(val) > 0) {
			depth++;
			return depth(n.leftChild, depth, val);
		} else {
			depth++;
			return depth(n.rightChild, depth, val);
		}


	}
	
	// Method #2.
	//Implementation version 1
	protected int depth(E val) {
		if (val == null) return -1;
		return depth(root, 0, val);	
	}

	
//	// Method #2.
//	//Implementation without recursion
//	protected int depth(E val) {
//
//		if (val == null) return -1;
//		
//		boolean loop = true;
//		Node n = root;
//		int depth = 0;
//		while (loop) {
//			if (n == null) {
//				depth = -1;
//				loop = false;
//			} else if (n.value.equals(val)) {
//				loop = false;
//			} else if (n.value.compareTo(val) > 0) {
//				depth++;
//				n = n.leftChild;
//			} else {
//				depth++;
//				n = n.rightChild;
//			}
//			
//		}
//		
//		return depth;
//
//	}
	

	public int calculateHeight(Node n) {
		if (n == null) return 0;
		
		int height =+ calculateHeight(n.leftChild);
		int leftHeight = height;
		height = 0;
		height =+ calculateHeight(n.rightChild);
		if (leftHeight > height) {
			height = leftHeight;
		}
		if (n.leftChild == null && n.rightChild == null) {
			//leaf
			height = 0;
		} else {
			height++;
		}
		return height;
	}
		
	protected int height(E val) {

		if (val == null) return -1;
		
		Node n = findNode(val);
		if (n == null) return -1;
		return calculateHeight(n);
		

	}


	// Method #4.
	protected boolean isBalanced(Node n) {
		
		if (n == null) return false;
		
		Node node = findNode(n.value);
		if (node == null) return false;

		if (node.leftChild == null && node.rightChild == null) {
			return true;
		}
		
		int leftHeight = calculateHeight(n.leftChild);
		int rightHeight = calculateHeight(n.rightChild);
		
		int dif = Math.abs(leftHeight - rightHeight);
		if (dif == 0) {
			return true;
		} else if (dif == 1) {
			if (n.leftChild == null || n.rightChild == null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
				
	
	}
	
	boolean isNodeBalanced = false;
	private void isNodeBalanced(Node n) {
		if (n == null) return ;
		isNodeBalanced(n.leftChild);
		if (isBalanced(n)) {
			isNodeBalanced = true;
		} else {
			isNodeBalanced = false;
		}
		if (isNodeBalanced) {
			isNodeBalanced(n.rightChild);
		}
	}

	
	// Method #5. .
	public boolean isBalanced() {
		isNodeBalanced(root);
		return isNodeBalanced;
	}
	

}
