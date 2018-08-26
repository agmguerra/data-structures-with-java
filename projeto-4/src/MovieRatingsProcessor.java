/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		
		List<String>orderedMovies = new LinkedList<String>();
		
		if (movieRatings == null || movieRatings.isEmpty()) {
			return orderedMovies;
		}
		 
		Set<String> set = movieRatings.keySet();
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			String movie = (String) iterator.next();
			orderedMovies.add(movie);
		}
		
		return orderedMovies;
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		List<String> moviesAboveRating = new LinkedList<String>();
		if (movieRatings == null || movieRatings.isEmpty()) {
			return moviesAboveRating;
		}
		
		
		Set<Entry<String, PriorityQueue<Integer>>> entries = movieRatings.entrySet();
		for (Entry<String, PriorityQueue<Integer>> entry : entries) {
			if (entry.getValue().element() > rating) {
				moviesAboveRating.add(entry.getKey());
			}
		}
		
		return moviesAboveRating;
	}
	
	
	private static int removeRatings(PriorityQueue<Integer> movieRatings, int rating) {
		
		int cont = 0;
		while (true) {
			Integer el = movieRatings.peek();
			
			if (el != null && el < rating) {
				movieRatings.poll();
				cont++;	
			} else {
				break;
			}
		}
		return cont;
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		TreeMap<String, Integer> moviesRemoved = new TreeMap<String, Integer>();
		if (movieRatings == null || movieRatings.isEmpty()) {
			return moviesRemoved;
		}
		
		
		Set<Entry<String, PriorityQueue<Integer>>> entries = movieRatings.entrySet();
		List<Entry<String, PriorityQueue<Integer>>> remover = new ArrayList<Entry<String, PriorityQueue<Integer>>>();
		for (Entry<String, PriorityQueue<Integer>> entry : entries) {
			
			int cont = removeRatings(entry.getValue(), rating);
			if (cont > 0) {
				moviesRemoved.put(entry.getKey(), cont);
				if (entry.getValue().isEmpty()) {			
					remover.add(entry);
				} 
			}
		}
		
		//remover
		entries.removeAll(remover);
		
		return moviesRemoved;
	}
}
