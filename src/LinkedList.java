
public class LinkedList {
	
	class Node {
		int value;
		Node next = null;
		Node(int value) {
			this.value = value;
		}
	}
	
	protected Node head = null;
	protected Node tail = null;
	
	public void addToFront(int value) {
		Node newNode = new Node(value);
		newNode.next = head;
		head = newNode;
		
		//if there is only one node
		if (newNode.next == null) {
			tail = newNode;
		}
	}
	
	public void addToBack(int value) {
		Node newNode = new Node(value);
		if (tail == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
	}

	public void addAtIndex(int index, int value) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			addToFront(value);
		} else {
			Node newNode = new Node(value);
			Node current = head;
			for (int i = 0; i < index-1; i++) {
				//if an index is greater than the number of elements
				if (current == null) {
					throw new IndexOutOfBoundsException();
				}
				current = current.next;
			}
			//if the insertion is at the end
			if (current.next == null) {
				tail = newNode;
			} else {
				newNode.next = current.next;
				current.next = newNode;
			}
		}
		
		
	}
}
