package heap;

public class Heap {
	
	int[] values;
	int size = 0;
	
	public Heap(int maxHeight) {
		values = new int[(int)Math.pow(2, maxHeight) - 1];
	}

	public void swapValues(int index1, int index2) {
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}
}
