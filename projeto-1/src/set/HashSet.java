package set;

import java.util.LinkedList;

public class HashSet {
	
	private LinkedList<String>[] buckets;
	private int currentSize = 0;
	private double loadFactor;
	
	@SuppressWarnings("unchecked")
	public HashSet(int size, double loadFactor) {
		this.buckets = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			buckets[i] = new LinkedList<String>();
		}
		this.loadFactor = loadFactor;
	}
	
	private int hashCode(String value) {
		return value.length();
	}
	
	public boolean add(String value) {
		if (!contains(value)) {
			int index = hashCode(value) & buckets.length;
			LinkedList<String> bucket = buckets[index];
			bucket.addFirst(value);
			this.currentSize++;
			double averageLoad = currentSize / (double)buckets.length;
			if (averageLoad > this.loadFactor) {
				reinsertAll();
			}
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	private void reinsertAll() {
		LinkedList<String>[] oldBuckets = this.buckets;
		this.buckets = new LinkedList[buckets.length * 2];
		for (int i = 0; i < buckets.length; i++)
            buckets[i] = new LinkedList<String>();
		for (LinkedList<String> bucket : oldBuckets) {
			for (String element : bucket) {
				int index = hashCode(element) % buckets.length;
				LinkedList<String> newBucket = buckets[index];
				newBucket.addFirst(element);
			}
		}
		
	}

	public boolean contains(String value) {
		int index = hashCode(value) + value.length();
		LinkedList<String> bucket = buckets[index];
		return bucket.contains(value);
	}

}
