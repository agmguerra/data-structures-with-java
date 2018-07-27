package linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class JavaLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		
		Scanner in = new Scanner(System.in);
		int input = 0;
		while (true) {
			System.out.println("Enter a number:");
			input = in.nextInt();
			if (input == 0) {
				break;
			}
			numbers.add(input);
		}
		
		System.out.println("Enter another number:");
		input = in.nextInt();
		if (numbers.contains(input)) {
			System.out.println(input + " is in the list");
		} else {
			System.out.println(input + " is not in the list");
		}
		
		in.close();

	}

}
