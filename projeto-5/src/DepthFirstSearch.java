

import java.util.HashSet;
import java.util.Set;

/*
 * SD2x Homework #6
 * This is an implementation of Depth First Search (DFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class DepthFirstSearch {
	protected Set<String> marked;
	protected Graph graph;
	protected Node init;
	protected int cont = 0;


	
	public DepthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<String>();
		graph = graphToSearch;
	}
	
	
	public void nodesWithinDistance(Node start, int distance) {
		if (!graph.containsNode(start)) {
			return ;
		}	
	
		cont++;
		if ((cont - 1) <= distance) {
			if (!marked.contains(start.getElement())) {
				marked.add(start.getElement());
			}
			for (Node neighbor : graph.getNodeNeighbors(start)) {
				nodesWithinDistance(neighbor, distance);	
				cont--;
			}
		}
		
	}
		
	public Set<String> getResult() {
		return marked;
	}
}
