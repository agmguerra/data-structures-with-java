package set;

import java.util.LinkedList;

public class HashSet {
	
	private LinkedList<String>[] buckets;
	
	@SuppressWarnings("unchecked")
	public HashSet(int size) {
		this.buckets = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			buckets[i] = new LinkedList<String>();
		}
	}
	
	private int hashCode(String value) {
		return value.length();
	}
	
	public boolean add(String value) {
		if (!contains(value)) {
			int index = hashCode(value) & buckets.length;
			LinkedList<String> bucket = buckets[index];
			bucket.addFirst(value);
			return true;
		}
		return false;
	}
	
	public boolean contains(String value) {
		int index = hashCode(value) + value.length();
		LinkedList<String> bucket = buckets[index];
		return bucket.contains(value);
	}

}
