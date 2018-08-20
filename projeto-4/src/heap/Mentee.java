package heap;

import java.util.PriorityQueue;

public class Mentee implements Comparable<Mentee> {
	
	protected int year;
	protected String name;
	
	public Mentee(int year, String name) {
		super();
		this.year = year;
		this.name = name;
	}

	@Override
	public int compareTo(Mentee otherMentee) {
		return year - otherMentee.year;
	}
	
	public static String[] acceptMenteeIntoProgram(int numMentorAvailable, PriorityQueue<Mentee> interestedMentees) {
		
		int numToAccept = Math.min(interestedMentees.size(), numMentorAvailable);
		String[] menteesInProgram = new String[numToAccept];
		for (int i = 0; i < numToAccept; i++) {
			Mentee mentee = interestedMentees.remove();
			menteesInProgram[i] = mentee.name;
		}
		return menteesInProgram;
	}
	
	
}
