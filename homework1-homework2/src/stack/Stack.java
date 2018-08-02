package stack;

import java.util.LinkedList;

public class Stack {
	
	protected LinkedList<Object> list = new LinkedList<Object>();
	
	public void push(Object value) {
		list.addFirst(value);
	}
	
	public Object pop() {
		return list.getFirst();
	}
}
