

import java.util.Iterator;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static void insertSorted(LinkedList<Integer> list, int value) {
		
		if  (list == null) {
			return;
		}
		
		if (list.isEmpty()) {
			list.add(value);
		} else if (value <= list.getFirst()) {
			list.addFirst(value);
		} else if (value >= list.getLast()) {
			list.add(value);
		} else {
		
			for (int i = 0; i < list.size(); i++) {
				if (value < list.get(i)) {
					list.add(i, value);
					break;
				}
			}
		}

	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {

		if (list == null || N < 0) {
			return;
		}
		if (N >= list.size()) {
			list.clear();
		}
		LinkedList<String> removedsList = new LinkedList<String>();
		String maxStr = "";
		for (String str : list) {
			int res = maxStr.compareTo(str);
			if (res == 1) {
				
			}
		}
		

	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		/* IMPLEMENT THIS METHOD! */
		
		return true; // this line is here only so this code will compile if you don't modify it
	}
}
