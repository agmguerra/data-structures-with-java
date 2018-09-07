

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;

	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
	}
	
	/**
	 * This method was discussed in the lesson
	 */
	public int minDistance(Node start, String elementToFind) {
		
		Map<Node, Node> result = new HashMap<>();
		if (!graph.containsNode(start)) {
				return -1;
		}
		if (start.getElement().equals(elementToFind)) {
			return 0;
		}
		Queue<Node> toExplore = new LinkedList<Node>();
		marked.add(start);
		toExplore.add(start);
		result.put(start, null);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();

			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					result.put(neighbor, current);
					if (neighbor.getElement().equals(elementToFind)) {
						
						return extractShortestPathLenght(neighbor, result);
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
			
		}
		return -1;
	}
	
	private int extractShortestPathLenght(Node elementFinded, Map<Node, Node> paths) {
		boolean hasPath = false;
		Node element = elementFinded;
		int cont = 0;
		while (!hasPath) {
			Node a = paths.get(element);
			if (a != null) {
				cont++;
				element = a;
			} else {
				hasPath = true;
			}
		}
		return cont;
	}
	

}
