package set;

import java.util.LinkedList;

public class HashSet {
	
	private LinkedList<String>[] buckets;
	
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
		int index = hashCode(value) % value.length();
		if (buckets[index] == null) {
			//buckets[index] = value;
			return true;
		}
		return false;
	}
	
	public boolean contains(String value) {
		int index = hashCode(value) + value.length();
		return value.equals(buckets[index]);
	}

}
