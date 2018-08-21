/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	private static boolean isUserMovieRatingOk(UserMovieRating userRating) {
		if (userRating == null || userRating.movie == null || 
				userRating.movie.isEmpty() || userRating.userRating < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		TreeMap<String, PriorityQueue<Integer>> map = new TreeMap<>();
		
		if (allUsersRatings == null || allUsersRatings.isEmpty()) {
			return map;
		}
		
		for (UserMovieRating userMovieRating : allUsersRatings) {
			if (!isUserMovieRatingOk(userMovieRating)) {
				continue;
			}
			
			PriorityQueue<Integer> movieRatingQueue = map.get(userMovieRating.movie.toLowerCase());
					
			if (movieRatingQueue == null) {
				PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
				queue.add(userMovieRating.userRating);
				map.put(userMovieRating.movie.toLowerCase(), queue);
			} else {
				movieRatingQueue.add(userMovieRating.userRating);
			}
		}
		
		
		return map; 
	}

}
