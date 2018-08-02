


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
	

	private static String getMaxString(LinkedList<String> list) {
		String max = "";
		for (String val : list) {
			if (val.compareTo(max) > 0) {
				max = val;
			}
		}
		return max;
	}
	
	
	public static void removeMaximumValues(LinkedList<String> list, int N) {

		if (list == null || N < 0) {
			return;
		}
		if (N >= list.size()) {
			list.clear();
		} else {
			int faltaRemover = N;
			while (faltaRemover > 0) {
				final String str = getMaxString(list);
				list.removeIf(s -> s.equals(str));
				faltaRemover--;
			}
		}
	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		if (one == null || one.isEmpty()) {
			return false;
		}
		if (two == null || two.isEmpty()) {
			return false;
		}
		if (two.size() > one.size()) {
			return false;
		}
		
		boolean ret = false;
		int i = 0;
		int val = one.size() - two.size() + 1;
		while (i < val) {
			ret = true;
			int y = 0;
			for(int j = i; j < i + two.size(); j++) {
				if (one.get(j) != two.get(y)) {
					ret = false;
					break;
				}
				y++;
			}
			if (ret) {
				break;
			}
			i++;
		}
		
		return ret; // this line is here only so this code will compile if you don't modify it
	}
}
