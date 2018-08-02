package queue;

import java.util.LinkedList;

public class Queue {
	
	protected LinkedList<Object> list = new LinkedList<Object>();

	public void add(Object value) {
		list.add(value);  //add to the end of the list (queue)
	}
	
	public Object remove() {
		if (list.isEmpty()) {
			return null;
		}
		return list.removeFirst();  //removes from front
	}
}
